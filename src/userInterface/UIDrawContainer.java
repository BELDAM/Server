package userInterface;

public interface UIDrawContainer {
	void accept(UIElement element);
	void drawOver(String[] block, int posX, int posY);
}
