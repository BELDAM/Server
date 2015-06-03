package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionListener implements Runnable {

    public final int TELNET_PORT = 23;

    private ServerSocket socket;
    private boolean running = true;

    public ConnectionListener() {
        try {
            socket = new ServerSocket(TELNET_PORT);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (running) {
                Socket communication = socket.accept();
                ConnectionHandler handler = new ConnectionHandler(communication);
                new Thread(handler).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ConnectionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stop() {
        running = false;
    }
}
