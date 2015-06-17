package userInterface.screens.mainInterface;

import characters.*;
import server.GameManager;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Companions extends UIElement {
	public Companions(int posX, int posY) {
		super(posX, posY);
		update();
	}

	public void update() {
		ascii.clear();

		ascii.add("+------------+");
		ascii.add("| Companions |");
		ascii.add("+------------+");

		for (characters.Character c: GameManager.getInstance().getPlayers()) {
			String name = c.getName();
			int nameLength = 8;

			if(name.length() > nameLength) {
				name = name.substring(0, nameLength);
			} else {
				while (name.length() != nameLength) {
					name += " ";
				}
			}

			ascii.add("| " + name + " " + c.getSymbol() + " |");
		}

		ascii.add("+------------+");
	}

	@Override
	public void visit(UIDrawContainer screen) {
		screen.drawOver(toAscii(), posX, posY);
	}
}
