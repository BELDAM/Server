package userInterface.screens.mainInterface;

import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Messages extends UIElement {
	public Messages(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void visit(UIDrawContainer screen) {
		screen.drawOver(toAscii(), posX, posY);
	}
}
