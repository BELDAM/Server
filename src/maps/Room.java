package maps;

public class Room {

    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;

    private Room north;
    private Room south;
    private Room west;
    private Room east;

    private String[] representation = new String[]{
        "+-------+  ",
        "|       |  ",
        "|       |  ",
        "|       |  ",
        "+-------+  ",
        "           "};

    public Room(Room north, Room south, Room west, Room east) {
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;

        updateRepresentation();
    }

    public Room() {
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
    }
}
