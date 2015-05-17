package utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigParser {
    
    private ConfigParser() {
    }
    
    private static List<String> coordinates;
    
    public static List<String> coordinatesCSV() {
        if (coordinates == null) {
            try {
                coordinates =  new ArrayList<>();
                URI uri = ClassLoader.getSystemClassLoader().getResource("assets/coordinates.csv").toURI();
                try (BufferedReader reader = new BufferedReader(new FileReader(new File(uri)))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        coordinates.add(line);
                    }
                }
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(ConfigParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return coordinates;
    }
}
