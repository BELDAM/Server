package userInterface.screens.mainInterface;

import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Companions extends UIElement {
	public Companions(int posX, int posY) {
		super("assets/panels/companions.txt", posX, posY);
	}

	@Override
	public void visit(UIDrawContainer screen) {
		// TODO players
		screen.drawOver(toAscii().split("\r\n"), posX, posY);
	}
}
