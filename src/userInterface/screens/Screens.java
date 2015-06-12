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

    public static String mainScreen() {
        String screen = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("assets/screens/mainExample.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                screen += line + "\r\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
        }

        return screen;
    }

    /**
     * Modify the current displayed screen, inserting a block of text over the current screen.
     * @param currentScreen Screen you want to write on
     * @param newText New block of text
     * @param posX Position x from left border. If x < 0, position from right border
     * @param posY Position y from top border. If y < 0, position from bottom border
     * @return The new screen
     */
    public static String modify(String currentScreen, String[] newText, int posX, int posY) {
        String[] lines = currentScreen.split("\r\n");

        for (int i = 0; i < newText.length; i++) {
            char[] chars;

            if (posY >= 0) {
                chars = lines[i + posY].toCharArray();
            } else {
                chars = lines[(lines.length - 1) - i + posY].toCharArray();
            }

            for (int j = 0; j < newText[i].length(); j++) {
                if (posX >= 0) {
                    chars[j + posX] = newText[i].toCharArray()[j];
                } else {
                    if (posY >= 0) {
                        chars[(chars.length - 1) - j + posX] = newText[(newText.length - 1) - i].toCharArray()[j];
                    } else {
                        char[] newChars = newText[(newText.length - 1) - i].toCharArray();
                        chars[(chars.length - 1) - j + posX] = newChars[(newChars.length - 1) - j];
                    }
                }
            }

            if (posY >= 0) {
                lines[i + posY] = new String(chars);
            } else {
                lines[(lines.length - 1) - i + posY] = new String(chars);
            }
        }

        return String.join("\r\n", lines);
    }
}
