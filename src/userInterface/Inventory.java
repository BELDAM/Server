package userInterface;

public class Inventory implements UIElement, UIDrawContainer {
	private UIElement[] children;

	@Override
	public String[] toAscii() {
		// TODO this is a stub
		return new String[0];
	}

	public void visit(UIDrawContainer screen) {
		for (UIElement child: children) {
			accept(child);
		}

		screen.drawOver(toAscii(), posX, posY);
	}

	public void accept(UIElement slot) {
		slot.visit(this);
	}

	@Override
	public void drawOver(String[] block, int posX, int posY) {
		// TODO Add @block over the this.toAscii block
	}
}
