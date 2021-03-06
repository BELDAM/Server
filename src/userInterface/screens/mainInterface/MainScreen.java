package userInterface.screens.mainInterface;

import characters.Character;
import userInterface.screens.Screen;
import userInterface.screens.Screens;
import userInterface.screens.UIElement;

import java.util.ArrayList;

public class MainScreen implements Screen {

    private ArrayList<UIElement> panels = new ArrayList<>();
    private String ascii = "";

    private Inventory inventory = new Inventory(92, 0);
    private Stats stats = new Stats(92, 21);
    private Companions companions = new Companions(79, 0);
    private Messages messages = new Messages(2, 1);

    public Stats getStats() {
        return stats;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Messages getMessages() {
        return messages;
    }

    public Companions getCompanions() {
        return companions;
    }

    public MainScreen() {
		panels.add(inventory);
		panels.add(stats);
		panels.add(messages);
        panels.add(companions);

        ascii = Screens.emptyScreen();
    }

    public void update(Character player) {
        stats.update(player);
        companions.update();
    }

    @Override
    public String toASCII() {
        for (UIElement panel : panels) {
            accept(panel);
        }

        return ascii + "\r\n";
    }

    @Override
    public void drawOver(String[] block, int posX, int posY) {
        String[] lines = ascii.split("\r\n");

        for (int i = 0; i < block.length; i++) {
            char[] chars;

            chars = lines[i + posY].toCharArray();

            for (int j = 0; j < block[i].length(); j++) {
                chars[j + posX] = block[i].toCharArray()[j];
            }

            lines[i + posY] = new String(chars);
        }

        ascii = String.join("\r\n", lines);
    }

    @Override
    public void accept(UIElement inventory) {
        inventory.visit(this);
    }

    @Override
    public String toString() {
        return this.toASCII();
    }
}
