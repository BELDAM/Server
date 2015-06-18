package server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import items.BodyPart;
import items.Item;
import userInterface.screens.Screens;
import userInterface.utils.Writer;
import characters.Character;
import characters.CharacterFactory;
import userInterface.screens.Screen;
import userInterface.screens.map.Map;
import userInterface.screens.mainInterface.MainScreen;
import userInterface.screens.map.Room;
import userInterface.utils.IllegalMoveException;
import utils.IllegalTargetException;

public class ConnectionHandler implements Runnable {

    private Socket connection;
    private BufferedReader in;
    private BufferedWriter out;

    private Character player;
    private Map currentMap;
    private Room currentRoom;
    private MainScreen mainScreen;

    private PlayerState state;
    private PlayerState previousState;

    private java.util.Map<PlayerState, String> helpMessages = new HashMap<>();

    private boolean running;

    public ConnectionHandler(Socket socket) {
        state = PlayerState.MAIN;

        initHelps(PlayerState.MAIN, "assets/text/help-main.txt");
        initHelps(PlayerState.FIGHT, "assets/text/help-fight.txt");

        try {
            connection = socket;
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            running = true;
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            clearScreen();
            out.write(Screens.titleScreen());
            out.flush();
            in.readLine();
            createCharacter();

            GameManager.getInstance().registerConnection(this, player);

            currentMap = GameManager.getInstance().getWorldMap();
            mainScreen = new MainScreen();
            mainScreen.update(player);

            clearScreen();
            out.write(mainScreen.toString());
            out.flush();

            currentRoom = currentMap.getStartingRoom();

            mainLoop();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                clearScreen();

                in.close();
                out.close();
                connection.close();

                GameManager.getInstance().disconnect(this, player);
                currentRoom.removePlayer(player);
            } catch (IOException ex) {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createCharacter() throws IOException {
        String[] name_avatar;
        CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
        do {
            clearScreen();
            out.write(Screens.characterCreationScreen());
            out.flush();

            name_avatar = in.readLine().split(" ");
        } while (name_avatar.length != 2 || name_avatar[0].length() < 2 || name_avatar[1].length() != 1
                || !asciiEncoder.canEncode(name_avatar[0]) || !asciiEncoder.canEncode(name_avatar[1]));

        String[] message = {"Choose your race", "", "ELF - HUMAN - ORC"};
        do {
            clearScreen();
            out.write(Writer.Write(message, Writer.CENTER));
            out.flush();

            String race = in.readLine();
            CharacterFactory factory = new CharacterFactory();
            player = factory.createCharacter(name_avatar[0], name_avatar[1].charAt(0), race);
            GameManager.getInstance().registerNewPlayer(player);
        } while (player == null);
    }

    private void mainLoop() throws IOException {
        while (running) {
            String input = in.readLine();

            if (input.equals("")) {
                printScreen();

                continue;
            }

            printMessage("");
            printMessage("> " + input);

            String[] command = input.split(" ");

            try {
                if (state == PlayerState.MAIN) {
                    switch (Command.valueOf(command[0].toUpperCase())) {
                        case MOVE:
                            Direction direction = Direction.valueOf(command[1].toUpperCase());
                            currentMap.move(player, currentRoom, direction);
                            currentRoom = currentRoom.getRoom(direction);
                            move();
                            break;
                        case MAP:
                            previousState = state;
                            state = PlayerState.MAP;
                            break;
                        case TAKE:
                            takeItem(command[1]);
                            break;
                        case DROP:
                            dropItem(command[1]);
                            break;
                        case QUIT:
                            running = false;
                            break;
                        case HELP:
                            printMessage(helpMessages.get(state));
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                } else if (state == PlayerState.MAP) {
                    switch (command[0].toUpperCase()) {
                        case "MOVE":
                            // TODO not allow during fights
                            Direction direction = Direction.valueOf(command[1].toUpperCase());
                            currentMap.move(player, currentRoom, direction);
                            currentRoom = currentRoom.getRoom(direction);
                            move();
                            break;
                        default:
                            state = previousState;
                            break;
                    }
                } else if (state == PlayerState.FIGHT) {
                    switch (Command.valueOf(command[0].toUpperCase())) {
                        case ATTACK:
                            try {
                                GameManager.getInstance().getFight(currentRoom).attackMonster(player, Integer.parseInt(command[1]));
                            } catch (IllegalTargetException e) {
                                printMessage("Monster #" + Integer.parseInt(command[1]) + " doesn't exist.");
                            }
                            break;
                        case MAP:
                            previousState = state;
                            state = PlayerState.MAP;
                            break;
                        case QUIT:
                            running = false;
                            break;
                        case HELP:
                            printMessage(helpMessages.get(state));
                            break;
                        case TAKE:
                        case DROP:
                        case MOVE:
                            printMessage("You can't do that during a fight!");
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            } catch (IllegalMoveException e) {
                printMessage("You can't go in this direction!");
            } catch (IllegalArgumentException e) {
                printMessage("Invalid command " + command[0]);
            } catch (IllegalTargetException e) {
                printMessage("There is no item #" + command[1]);
                printMessage(currentRoom.getItems().toString());
            } finally {
                printScreen();
            }
        }
    }

    private void move() {
        if (GameManager.getInstance().roomHasAFight(currentRoom)) {
            printMessage("You joined a fight!");
            GameManager.getInstance().getFight(currentRoom).joinFight(player);
            state = PlayerState.FIGHT;
        } else if (Math.random() < 0.5 && currentRoom != currentMap.getStartingRoom() && currentRoom.playerCount() == 1) {
            printMessage("You encountered some ennemies!");
            GameManager.getInstance().startAFight(currentRoom);
            GameManager.getInstance().getFight(currentRoom).joinFight(player);
            state = PlayerState.FIGHT;
        }
    }

    public void refreshMainScreen() {
        mainScreen.update(player);
    }

    private void initHelps(PlayerState state, String filename) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filename));

            helpMessages.put(state, new String(encoded, "UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void takeItem(String itemId) throws IllegalTargetException {
        try {
            int id = Integer.parseInt(itemId);

            if (id > 0 && id <= currentRoom.getItems().size()) {
                Item item = currentRoom.getItems().get(id-1);
                if (!player.hasItem(item.getBodyPart())) {
                    player.addItem(item);
                    mainScreen.getInventory().addItem(item.getBodyPart());
                    currentRoom.getItems().remove(id - 1);
                } else {
                    printMessage("You cannot take this item, because you already have one.");
                }
            } else {
                throw new IllegalTargetException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalTargetException();
        }
    }

    private void dropItem(String itemId) throws IllegalTargetException {
        try {
            int id = Integer.parseInt(itemId);

            if (id > 0 && id <= 7) {
                BodyPart part = BodyPart.RIGHT_HAND;

                switch (id) {
                    case 1:
                        part = BodyPart.HEAD;
                        break;
                    case 2:
                        part = BodyPart.SHOULDERS;
                        break;
                    case 3:
                        part = BodyPart.TORSO;
                        break;
                    case 4:
                        if (player.hasItem(BodyPart.BOTH_HANDS)) {
                            part = BodyPart.BOTH_HANDS;
                        } else {
                            part = BodyPart.RIGHT_HAND;
                        }
                        break;
                    case 5:
                        part = BodyPart.LEGS;
                        break;
                    case 6:
                        part = BodyPart.LEFT_HAND;
                        break;
                    case 7:
                        part = BodyPart.FEET;
                        break;
                }

                Item item = null;

                if (player.hasItem(part)) {
                    for (int i = 0; i < player.getItems().size(); i++) {
                        if (player.getItems().get(i).getBodyPart() == part) {
                            item = player.getItems().get(i);
                        }
                    }

                    System.out.println("part: " + part);
                    System.out.println("item: " + item);

                    currentRoom.getItems().add(item);
                    player.getItems().remove(item);
                    mainScreen.getInventory().removeItem(part);
                } else {
                    printMessage("You don't carry any item on this part of your body. Please refer to the little grid in your inventory.");
                }
            } else {
                throw new IllegalTargetException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalTargetException();
        }
    }

    private void printScreen() throws IOException {
        mainScreen.update(player);

        clearScreen();

        Screen currentScreen = mainScreen;

        switch (state) {
            case MAIN:
            case FIGHT:
                currentScreen = mainScreen;
                break;
            case MAP:
                currentScreen = currentMap;
                break;
        }

        out.write(currentScreen.toString());

        out.flush();
    }

    public void printMessage(String msg) {
        mainScreen.getMessages().addMessage(msg.split("\r?\n"));
    }

    public void setState(PlayerState s) {
        state = s;
    }

    private void clearScreen() throws IOException {
        out.write("\033[2J");
        out.flush();
    }
}
