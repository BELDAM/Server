package server;

public class GameManager implements Runnable{

    private ConnectionListener listener;

    public GameManager() {
        listener = new ConnectionListener();
    }

    public void startGame() {
        new Thread(listener).start();
    }

    @Override
    public void run() {
    }
}
