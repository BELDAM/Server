package userInterface.screens.map;

import utils.ConfigParser;
import userInterface.screens.Screen;
import userInterface.screens.UIElement;
import characters.Character;
import server.Direction;
import userInterface.screens.Screens;
import userInterface.utils.IllegalMoveException;

public class Map implements Screen {

    private static int NUMBER_OF_ROOMS_X = 10;
    private static int NUMBER_OF_ROOMS_Y = 6;

    private Room[][] rooms;
    private Room startingRoom;

    private String[] representation;

    public Map(String name) {
        rooms = new Room[NUMBER_OF_ROOMS_X][NUMBER_OF_ROOMS_Y];

        representation = Screens.mapScreen().split("\r\n");
        for (int i = 0; i < representation.length; i++) {
            if (i < name.length()) {
                representation[i + 1] = representation[i + 1].substring(0, 115) + name.charAt(i) + representation[i + 1].substring(116);
            } else if (i == name.length()) {
                representation[i + 1] = representation[i + 1].substring(0, 113) + "-----|";
            }
        }

        for (String line : ConfigParser.csv("assets/coordinates.csv")) {
            String[] tokens = line.split(";");

            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            Room room = new Room(x, y);
            rooms[x][y] = room;

            for (int i = 2; i < tokens.length; i++) {
                switch (tokens[i]) {
                    case "N":
                        room.makeLink(rooms[x][y - 1], Room.NORTH);
                        break;
                    case "S":
                        room.makeLink(rooms[x][y + 1], Room.SOUTH);
                        break;
                    case "W":
                        room.makeLink(rooms[x - 1][y], Room.WEST);
                        break;
                    case "E":
                        room.makeLink(rooms[x + 1][y], Room.EAST);
                        break;
                }
            }
        }
        startingRoom = rooms[0][0];
    }

    public void addPlayer(Character player) {
        startingRoom.addPlayer(player);
        updateRepresentation();
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    @Override
    public String toASCII() {
        return String.join("\r\n", representation) + "\r\n";
    }

    @Override
    public String toString() {
        updateRepresentation();
        return String.join("\r\n", representation) + "\r\n";
    }

    private void updateRepresentation() {
        for (int i = 0; i < NUMBER_OF_ROOMS_X; i++) {
            for (int j = 0; j < NUMBER_OF_ROOMS_Y; j++) {
                if (rooms[i][j] != null) {
                    accept(rooms[i][j]);
                }
            }
        }
    }

    public void move(Character player, Room room, Direction direction) throws IllegalMoveException {
        room.move(player, direction);
        updateRepresentation();
    }

    @Override
    public void accept(UIElement element) {
        element.visit(this);
    }

    @Override
    public void drawOver(String[] block, int posX, int posY) {
        String firstPart;
        String lastPart;
        for (int i = 0; i < block.length; i++) {
            if (posX == NUMBER_OF_ROOMS_X - 1) {
                block[i] = block[i].substring(0, block[i].length() - 1) + "|";
            }
            if (posY == NUMBER_OF_ROOMS_Y - 1 && i == block.length - 1) {
                block[i] = block[i].replace(' ', '-');
            }

            firstPart = representation[i + posY * block.length + 1].substring(0, posX * block[0].length() + 2);
            lastPart = representation[i + posY * block.length + 1].substring(2 + (posX + 1) * block[0].length());
            representation[i + posY * block.length + 1] = firstPart + block[i] + lastPart;
        }
    }
}
