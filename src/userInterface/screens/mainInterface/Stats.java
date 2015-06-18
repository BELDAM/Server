package userInterface.screens.mainInterface;

import characters.Character;
import server.GameManager;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

public class Stats extends UIElement {
	public Stats(int posX, int posY) {
		super(posX, posY);
	}

	public void update(Character player) {
		ascii.clear();

		ascii.add("+-------------------------+");
		ascii.add("|       Statistics        |");
		ascii.add("+-------------------------+");

		ascii.add("|                         ");
		ascii.add("| " + addPadding("Health Points: " + player.getHp(), 23));
		ascii.add("| " + addPadding("Level: " + player.getLevel(), 23));
		ascii.add("| " + addPadding("Experience: " + player.getXp(), 23));
		ascii.add("| " + addPadding("Strength: " + player.getStrength(), 23));
		ascii.add("| " + addPadding("Intelligence: " + player.getIntelligence(), 23));
		ascii.add("| " + addPadding("Defence: " + player.getPhysicalDefence(), 23));
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("+-------------------------+");
	}


	private String addPadding(String str, int length) {
		String padding = "";

		for (int i = str.length(); i < length; i++) {
			padding += " ";
		}

		return str + padding;
	}

	@Override
	public void visit(UIDrawContainer screen) {
		screen.drawOver(toAscii(), posX, posY);
	}
}
