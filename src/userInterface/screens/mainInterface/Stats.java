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
		ascii.add("| Health Points: " + player.getHp());
		ascii.add("| Level: " + player.getLevel());
		ascii.add("| Experience: " + player.getXp());
		ascii.add("| Strength: " + player.getStrength());
		ascii.add("| Intelligence: " + player.getIntelligence());
		ascii.add("| Defence: " + player.getPhysicalDefence());
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("|                         ");
		ascii.add("+-------------------------+");
	}

	@Override
	public void visit(UIDrawContainer screen) {
		screen.drawOver(toAscii(), posX, posY);
	}
}
