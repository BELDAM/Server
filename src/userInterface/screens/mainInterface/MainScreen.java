package userInterface.screens.mainInterface;

import userInterface.screens.Screen;
import userInterface.screens.Screens;
import userInterface.screens.UIElement;

import java.util.ArrayList;

public class MainScreen implements Screen {
	private ArrayList<UIElement> panels = new ArrayList<>();
	private String ascii = "";

	public MainScreen() {
		ascii = Screens.emptyScreen();

		panels.add(new Inventory(92, 0));
		panels.add(new Stats(92, 21));
		panels.add(new Companions(79, 0));
		panels.add(new Messages(0, 0));
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
