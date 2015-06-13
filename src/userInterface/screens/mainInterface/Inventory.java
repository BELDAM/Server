package userInterface.screens.mainInterface;

import items.BodyPart;
import userInterface.screens.UIDrawContainer;
import userInterface.screens.UIElement;

import java.util.ArrayList;

public class Inventory extends UIElement implements UIDrawContainer {
	private ArrayList<InventorySlot> slot = new ArrayList<>();

	Inventory(int posX, int posY) {
		super("assets/screens/inventory.txt", posX, posY);

		slot.add(0, new InventorySlot(3, 7));
		slot.add(1, new InventorySlot(11, 2));
		slot.add(2, new InventorySlot(19, 7));
		slot.add(3, new InventorySlot(11, 7));
		slot.add(4, new InventorySlot(3, 12));
		slot.add(5, new InventorySlot(11, 12));
		slot.add(6, new InventorySlot(19, 12));
		slot.add(7, new InventorySlot(11, 17));
	}

	public void addItem(BodyPart part) {
		switch (part) {
			case HEAD:
				slot.get(1).set("1-head.txt");
				break;
			case SHOULDERS:
				slot.get(0).set("2-shoulders-L.txt");
				slot.get(2).set("2-shoulders-R.txt");
				break;
			case TORSO:
				slot.get(3).set("3-torso.txt");
				break;
			case RIGHT_HAND:
				slot.get(4).set("4-right-hand.txt");
				break;
			case LEFT_HAND:
				slot.get(6).set("6-left-hand.txt");
				break;
			case BOTH_HANDS:
				slot.get(4).set("4-both-hands.txt");
				slot.get(6).disable();
				break;
			case LEGS:
				slot.get(5).set("5-legs.txt");
				break;
			case FEET:
				slot.get(7).set("7-feet.txt");
				break;
		}
	}

	public void removeItem(BodyPart part) {
		switch (part) {
			case HEAD:
				slot.get(1).empty();
				break;
			case SHOULDERS:
				slot.get(0).empty();
				slot.get(2).empty();
				break;
			case TORSO:
				slot.get(3).empty();
				break;
			case RIGHT_HAND:
				slot.get(4).empty();
				break;
			case LEFT_HAND:
				slot.get(6).empty();
				break;
			case BOTH_HANDS:
				slot.get(4).empty();
				slot.get(6).disable();
				break;
			case LEGS:
				slot.get(5).empty();
				break;
			case FEET:
				slot.get(7).empty();
				break;
		}
	}

	@Override
	public String toAscii() {
		return ascii;
	}

	public void visit(UIDrawContainer screen) {
		for (UIElement child: slot) {
			accept(child);
		}

		screen.drawOver(toAscii().split("\r\n"), posX, posY);
	}

	public void accept(UIElement slot) {
		slot.visit(this);
	}

	@Override
	public void drawOver(String[] block, int posX, int posY) {
		String[] lines = ascii.split("\r\n");

		for (int i = 0; i < block.length; i++) {
			char[] chars;

			if (posY >= 0) {
				chars = lines[i + posY].toCharArray();
			} else {
				chars = lines[(lines.length - 1) - i + posY].toCharArray();
			}

			for (int j = 0; j < block[i].length(); j++) {
				if (posX >= 0) {
					chars[j + posX] = block[i].toCharArray()[j];
				} else {
					if (posY >= 0) {
						chars[(chars.length - 1) - j + posX] = block[(block.length - 1) - i].toCharArray()[j];
					} else {
						char[] newChars = block[(block.length - 1) - i].toCharArray();
						chars[(chars.length - 1) - j + posX] = newChars[(newChars.length - 1) - j];
					}
				}
			}

			if (posY >= 0) {
				lines[i + posY] = new String(chars);
			} else {
				lines[(lines.length - 1) - i + posY] = new String(chars);
			}
		}

		ascii = String.join("\r\n", lines);
	}
}
