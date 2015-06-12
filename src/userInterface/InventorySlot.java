package userInterface;

public class InventorySlot implements UIElement {
	@Override
	public String[] toAscii() {
		// TODO this is a stub
		return new String[0];
	}

	@Override
	public void visit(UIDrawContainer inventory) {
		inventory.drawOver(this.toAscii(), posX, posY);
	}
}
