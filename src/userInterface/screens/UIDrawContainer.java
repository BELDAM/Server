package userInterface.screens;

public interface UIDrawContainer {
	void accept(UIElement element);

	/**
	 * Modify the current displayed screen, inserting a block of text over the current screen.
	 * @param block New block of text
	 * @param posX Position x from left border. If x < 0, position from right border
	 * @param posY Position y from top border. If y < 0, position from bottom border
	 * @return The new screen
	 */
	void drawOver(String[] block, int posX, int posY);
}
