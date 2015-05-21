package items;

public class Item {
	private String name;
	private int attack;
	private int defense;

	public Item(String name, int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}

	// Visitor Pattern
	public void accept(SuffixManager visitor) {
		visitor.visit(this);
	}

	public String toString() {
		return "Item '" + name + "': attack: " + attack + ", defense: " + defense;
	}
}
