package userInterface.screens.mainInterface;

import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Stats extends UIElement {
	public Stats(int posX, int posY) {
		super("assets/panels/stats.txt", posX, posY);
	}

	@Override
	public void visit(UIDrawContainer screen) {
		// TODO Add Stats
		screen.drawOver(toAscii().split("\r\n"), posX, posY);
	}
}
