package userInterface.screens.map;

import utils.ConfigParser;
import userInterface.screens.Screen;
import userInterface.screens.UIElement;
import characters.Character;
import server.Direction;
import userInterface.utils.IllegalMoveException;

public class Map implements Screen {

    private static String TOP_BOTTOM_BORDER = "+------------------------------------------------------"
            + "--------------------------------------------------------++-----+";

    private static int NUMBER_OF_ROOMS_X = 10;
    private static int NUMBER_OF_ROOMS_Y = 6;

    private Room[][] rooms;
    private String name;
    private Room startingRoom;

    private String[] representation;

    public Map(String name) {
        this.name = name;
        rooms = new Room[NUMBER_OF_ROOMS_X][NUMBER_OF_ROOMS_Y];

        representation = new String[37];

        for (String line : ConfigParser.csv("assets/coordinates.csv")) {
            String[] tokens = line.split(";");

            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            Room room = new Room();
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
        updateRepresentation();
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
        String result = "";
        int l = 1;
        int m = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS_Y; i++) {
            for (int k = 0; k < 6; k++) {
                for (int j = 0; j < NUMBER_OF_ROOMS_X; j++) {
                    if (rooms[j][i] != null) {
                        result += rooms[j][i].toASCII()[k];
                    } else {
                        result += "           ";
                    }
                }
                representation[l] = "| " + result.substring(0, result.length() - 2) + " ||";
                if (m < name.length()) {
                    representation[l] += "  " + name.charAt(m) + "  ";
                    m++;
                } else if (m == name.length()) {
                    representation[l] += "-----";
                    m++;
                } else {
                    representation[l] += "     ";
                }
                representation[l] += "|";
                result = "";
                l++;
            }
        }
        representation[0] = TOP_BOTTOM_BORDER;
        representation[36] = TOP_BOTTOM_BORDER;
    }

    public void move(Character player, Room room, Direction direction) throws IllegalMoveException {
        room.move(player, direction);
        updateRepresentation();
    }

    public void spawnMonsters() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if (rooms[i][j] != null || rooms[i][j] != startingRoom) {
                    rooms[i][j].spawnMonsters();
                }
            }
        }
    }

    @Override
    public void accept(UIElement element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawOver(String[] block, int posX, int posY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
