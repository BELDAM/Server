package server;

import java.util.ArrayList;
import userInterface.screens.map.Map;
import characters.Character;

public class GameManager {

    private ArrayList<Character> players;

    private Map worldMap;

    private GameManager() {
        players = new ArrayList<>();
        worldMap = new Map("OVERWORLD");
    }

    public static GameManager getInstance() {
        return Holder.instance;
    }

    public Map getWorldMap() {
        return worldMap;
    }
    
    public void registerNewPlayer(Character player){
        players.add(player);
        worldMap.addPlayer(player);
    }
    
    public ArrayList<Character> getPlayers() {
        return players;
    }
    
    private static class Holder {

        private static final GameManager instance = new GameManager();
    }
}
