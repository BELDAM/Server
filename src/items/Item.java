package items;

;

public class Item {
	private String name;
	private int attack;
	private int defense;
	private BodyPart bodyPart;

	public Item(String name, BodyPart bodyPart, int attack, int defense) {
		this.name = name;
		this.bodyPart = bodyPart;
		this.attack = attack;
		this.defense = defense;
	}

	public BodyPart getBodyPart() {
		return bodyPart;
	}

	public int getDefense() {
		return defense;
	}

	public int getAttack() {
		return attack;
	}

	public String getName() {
		return name;
	}

	public void addSuffix(Suffix suffix) {
		this.name += " " + suffix.name();
		this.attack += suffix.attack();
		this.defense += suffix.defense();
	}

	public String toString() {
		return "Item '" + name + " (" + bodyPart + ")': attack: " + attack + ", defense: " + defense;
	}
}
