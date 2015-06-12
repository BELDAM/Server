package userInterface.screens;

public interface UIElement {
	int posX = 0;
	int posY = 0;

	String[] toAscii();

	void visit(UIDrawContainer drawable);
}
