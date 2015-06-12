package userInterface;

public class MainScreen implements Screen {
	private Inventory inventory;

	public MainScreen() {
		inventory = new Inventory();
	}

	public String[] toAscii() {
		accept(inventory);

		return new String[0];
	}

	public void drawOver(String[] block, int posX, int posY) {
		// TODO Modify ASCII and draw it
	}

	@Override
	public void accept(UIElement inventory) {
		inventory.visit(this);
	}
}
