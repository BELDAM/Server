package server;

import maps.Map;

public class GameManager {

    private Map worldMap;

    private GameManager() {
        worldMap = new Map("overworld");
    }

    public GameManager getInstance() {
        return Holder.instance;
    }

    public Map getWorldMap() {
        return worldMap;
    }

    private static class Holder {

        private static final GameManager instance = new GameManager();
    }
}
