package server;

import java.util.ArrayList;
import userInterface.screens.map.Map;
import characters.Character;

public class GameManager {

    private ArrayList<Character> players;

    private Map worldMap;

    private static GameManager instance;

    private GameManager() {
        players = new ArrayList<>();        
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

    public void disconnect(Character player) {
        players.remove(player);
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

    private void spawnMonsters() {
        worldMap.spawnMonsters();
    }
}
