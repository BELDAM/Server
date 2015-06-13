package userInterface.screens.mainInterface;

import characters.*;
import server.GameManager;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Companions extends UIElement {

	public Companions(int posX, int posY) {
		super(posX, posY);

		ascii =
			"+------------+\r\n" +
			"| Companions |\r\n" +
			"+------------+\r\n"
		;

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

			ascii += "| " + name + " " + c.getSymbol() + " |\r\n";
		}

		ascii += "+------------+\r\n";
	}

	@Override
	public void visit(UIDrawContainer screen) {

		screen.drawOver(toAscii().split("\r\n"), posX, posY);
	}
}
