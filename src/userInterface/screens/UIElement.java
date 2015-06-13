package userInterface.screens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class UIElement {
	protected int posX = 0;
	protected int posY = 0;
	protected String ascii = "";

	public abstract String toAscii();

	public abstract void visit(UIDrawContainer drawable);

	public UIElement() {}

	public UIElement(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public UIElement(String filename, int posX, int posY) {
		this(posX, posY);
		fromFile(filename);
	}

	public UIElement(String filename) {
		fromFile(filename);
	}

	public void fromFile(String filename) {
		ascii = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = reader.readLine()) != null) {
				ascii += line + "\r\n";
			}
		} catch (IOException ex) {
			Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
