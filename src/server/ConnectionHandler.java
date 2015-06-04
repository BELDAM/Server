package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import userInterface.Screens;
import userInterface.Writer;

public class ConnectionHandler implements Runnable {

    private Socket connection;
    private BufferedReader in;
    private BufferedWriter out;

    public ConnectionHandler(Socket socket) {
        try {
            connection = socket;
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            out.write(Screens.titleScreen());
            out.flush();
            in.readLine();
            clearScreen();
            createCharacter();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
                connection.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createCharacter() throws IOException {
        out.write(Screens.characterCreationScreen());
        out.flush();
        String[] lines = in.readLine().split(" ");
        if (lines.length != 2) {
            clearScreen();
            out.write(Writer.WriteLine("caca", Writer.CENTER));
            out.flush();
        }
    }

    private void clearScreen() throws IOException {
        out.write("\033[2J");
        out.flush();
    }
}
