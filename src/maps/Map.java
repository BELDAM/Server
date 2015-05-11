package maps;

import utils.ConfigParser;

public class Map {

    private static int NUMBER_OF_ROOMS_X = 10;
    private static int NUMBER_OF_ROOMS_Y = 6;

    private Room[][] rooms;
    private String name;

    public Map(String name) {
        this.name = name;
        rooms = new Room[NUMBER_OF_ROOMS_X][NUMBER_OF_ROOMS_Y];

        for (String line : ConfigParser.coordinatesCSV()) {
            String[] tokens = line.split(";");

            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            Room room = new Room();

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
            rooms[x][y] = room;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < NUMBER_OF_ROOMS_Y; i++) {
            for (int k = 0; k < 6; k++) {
                for (int j = 0; j < NUMBER_OF_ROOMS_X; j++) {
                    if (rooms[j][i] != null) {
                        result += rooms[j][i].stringRepresentation()[k];
                    } else {
                        result += "           ";
                    }
                }
                result = result.substring(0, result.length() - 2) + "\r\n";
            }
        }
        return result;
    }
}
