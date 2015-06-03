package utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigParser {
    
    private ConfigParser() {
    }
    
    private static List<String> lines;
    
    public static List<String> csv(String filename) {
        if (lines == null) {
            try {
                lines =  new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ConfigParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lines;
    }
}
