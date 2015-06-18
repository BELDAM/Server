package server;

import java.util.ArrayList;
import userInterface.screens.map.Map;
import characters.Character;
import fight.FightManager;
import java.util.HashMap;
import userInterface.screens.map.Room;

public class GameManager {

    private ArrayList<Character> players;
    private ArrayList<ConnectionHandler> connections;
    private HashMap<Room, FightManager> fights;

    private Map worldMap;

    private static GameManager instance;

    private GameManager() {
        players = new ArrayList<>();
        connections = new ArrayList<>();
        worldMap = new Map("OVERWORLD");
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Map getWorldMap() {
        return worldMap;
    }

    public void registerNewPlayer(Character player) {
        players.add(player);
        worldMap.addPlayer(player);
    }

    public void registerConnection(ConnectionHandler connection) {
        connections.forEach(ConnectionHandler::refreshMainScreen);
        connections.add(connection);
    }

    public void disconnect(ConnectionHandler connection, Character player) {
        players.remove(player);
        connections.remove(connection);
        connections.forEach(ConnectionHandler::refreshMainScreen);
    }

    public ArrayList<Character> getPlayers() {
        return players;
    }

    public int getPartyLevel() {
        int level = 0;
        level = players.stream().map((c) -> c.getLevel()).reduce(level, Integer::sum);
        return level;
    }

    public int getPartySize() {
        return players.size();
    }

    public synchronized boolean roomHasAFight(Room room) {
        return fights.containsKey(room);
    }

    public synchronized void startAFight(Room room) {
        fights.put(room, new FightManager());
    }

    public FightManager getFight(Room room) {
        return fights.get(room);
    }
}
