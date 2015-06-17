package userInterface.screens.mainInterface;

import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Messages extends UIElement {
	private static int lineLength = 88;

	public Messages(int posX, int posY) {
		super(posX, posY);

		for (int i = 0; i < 35; i++) {
			ascii.add("");
		}
	}

	private void addMessage(String message) {
		String line = "";

		ArrayList<String> words = new ArrayList<>(Arrays.asList(message.split(" ")));

		while (!words.isEmpty()) {
			String word = words.get(0);

			if (line.length() + word.length() < lineLength) {
				line += (line.length() != 0) ? " " + word : word;
				words.remove(0);
			} else if (word.length() > lineLength) {
				words.set(0, word.substring(lineLength - line.length()));

				String s = word.substring(0, lineLength - line.length());
				line += (line.length() != 0) ? " " + s : s;

				ascii.remove(0);
				ascii.add(line);

				addMessage(String.join(" ", words.toArray(new String[words.size()])));

				return;
			} else {
				ascii.remove(0);
				ascii.add(line);

				addMessage(String.join(" ", words.toArray(new String[words.size()])));

				return;
			}
		}

		ascii.remove(0);
		ascii.add(line);
	}

	/**
	 * Print a message one the main interface. Also handles line wrap and very long words.
	 * @param message
	 */
	public void addMessage(String[] message) {
		for(String line: message) {
			addMessage(line);
		}
	}

	@Override
	public void visit(UIDrawContainer screen) {
		screen.drawOver(toAscii(), posX, posY);
	}
}
