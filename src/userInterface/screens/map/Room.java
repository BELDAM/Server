package userInterface.screens.map;

import java.util.ArrayList;
import characters.Character;
import server.Direction;
import userInterface.utils.IllegalMoveException;
import monsters.Monster;
import monsters.MonsterFactory;
import server.GameManager;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Room extends UIElement {

    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;

    private Room north;
    private Room south;
    private Room west;
    private Room east;

    private ArrayList<Character> players;

    private String[] representation = new String[]{
        "+-------+  ",
        "|       |  ",
        "|       |  ",
        "|       |  ",
        "+-------+  ",
        "           "};

    public Room(int posX, int posY) {
        super(posX, posY);
        players = new ArrayList<>();
    }

    public String[] toASCII() {
        return representation;
    }

    public void makeLink(Room r, int position) {
        if (r != null) {
            switch (position) {
                case NORTH:
                    north = r;
                    r.south = this;
                    break;
                case SOUTH:
                    south = r;
                    r.north = this;
                    break;
                case EAST:
                    east = r;
                    r.west = this;
                    break;
                case WEST:
                    west = r;
                    r.east = this;
                    break;
            }
            r.updateRepresentation();
            updateRepresentation();
        }
    }

    public void addPlayer(Character player) {
        players.add(player);
        updateRepresentation();
    }

    public void removePlayer(Character player) {
        players.remove(player);
        updateRepresentation();
    }

    public void move(Character player, Direction direction) throws IllegalMoveException {
        switch (direction) {
            case NORTH:
                if (north == null) {
                    throw new IllegalMoveException("can't go north");
                }
                north.addPlayer(player);
                north.updateRepresentation();
                break;
            case SOUTH:
                if (south == null) {
                    throw new IllegalMoveException("can't go south");
                }
                south.addPlayer(player);
                south.updateRepresentation();
                break;
            case EAST:
                if (east == null) {
                    throw new IllegalMoveException("can't go east");
                }
                east.addPlayer(player);
                east.updateRepresentation();
                break;
            case WEST:
                if (west == null) {
                    throw new IllegalMoveException("can't go west");
                }
                west.addPlayer(player);
                west.updateRepresentation();
        }
        players.remove(player);
        updateRepresentation();
    }

    public Room getRoom(Direction direction) {
        switch (direction) {
            case NORTH:
                return north;
            case SOUTH:
                return south;
            case EAST:
                return east;
            case WEST:
                return west;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.join("\r\n", representation);
    }

    private void updateRepresentation() {
        if (north != null) {
            representation[0] = "+--   --+  ";
        }
        if (south != null) {
            representation[4] = "+--   --+  ";
            representation[5] = "   | |     ";
        }
        if (east != null) {
            representation[2] = representation[2].substring(0, representation[2].length() - 3) + "   ";
            representation[1] = representation[1].substring(0, representation[2].length() - 2) + "__";
            representation[3] = representation[3].substring(0, representation[3].length() - 2) + "--";
        }
        if (west != null) {
            representation[2] = " " + representation[2].substring(1, representation[2].length());
        }

        char character;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (players.size() < (i * 3) + j + 1) {
                    character = ' ';
                } else {
                    character = players.get(j + (3 * i)).getAvatar();
                }
                representation[i + 1] = representation[i + 1].substring(0, (j + 1) * 2) + character + representation[i + 1].substring((j + 1) * 2 + 1);
            }
        }
    }

    @Override
    public void visit(UIDrawContainer drawable) {
        drawable.drawOver(representation, posX, posY);
    }
}
