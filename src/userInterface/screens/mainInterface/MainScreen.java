package userInterface.screens.mainInterface;

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
		ascii = Screens.emptyScreen();

		panels.add(inventory);
		panels.add(stats);
		panels.add(companions);
		panels.add(messages);
	}

	@Override
	public String toASCII() {
		for (UIElement pannel: panels) {
			accept(pannel);
		}

		return ascii;
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
	public String toString()
	{
		return this.toASCII();
	}
}
