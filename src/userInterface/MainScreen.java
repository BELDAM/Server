package userInterface;

public class MainScreen implements Screen {
	private Inventory inventory;

	public MainScreen() {
		inventory = new Inventory();
	}

        @Override
	public String[] toAscii() {
		accept(inventory);

		return new String[0];
	}

        @Override
	public void drawOver(String[] block, int posX, int posY) {
		// TODO Modify ASCII and draw it
	}

	@Override
	public void accept(UIElement inventory) {
		inventory.visit(this);
	}
        
        @Override
        public String toString()
        {
            return "skfjhgjsdfgsh"; //TODO need a printable version
        }
}
