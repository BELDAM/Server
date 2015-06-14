package userInterface.screens.mainInterface;

import items.BodyPart;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class InventorySlot extends UIElement {
	public InventorySlot(int posX, int posY) {
		super(posX, posY);
	}

	public void set(String filename) {
		fromFile("assets/inventory/" + filename);
	}

	public void empty() {
		fromFile("assets/inventory/empty.txt");
	}

	public void disable() {
		fromFile("assets/inventory/disable.txt");
	}

	@Override
	public void visit(UIDrawContainer inventory) {
		inventory.drawOver(this.toAscii(), posX, posY);
	}
}
