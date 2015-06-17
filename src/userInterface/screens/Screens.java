package userInterface.screens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Screens {

    private static String titleScreen;
    private static String characterCreationScreen;
    private static String emptyScreen;
    private static String mapScreen;

    private Screens() {
    }

    public static String titleScreen() {
        if (titleScreen == null) {
            titleScreen = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader("assets/screens/title.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    titleScreen += line + "\r\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return titleScreen;
    }

    public static String mapScreen() {
        if (mapScreen == null) {
            mapScreen = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader("assets/screens/map.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    mapScreen += line + "\r\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mapScreen;
    }

    public static String characterCreationScreen() {
        if (characterCreationScreen == null) {
            characterCreationScreen = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader("assets/screens/characterCreation.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    characterCreationScreen += line + "\r\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return characterCreationScreen;
    }

    public static String emptyScreen() {
        if (emptyScreen == null) {
            emptyScreen = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader("assets/screens/empty.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    emptyScreen += line + "\r\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emptyScreen;
    }
}
