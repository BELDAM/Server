package items;

public class Suffix {
	private String name;
	private int attack;
	private int defense;

	public Suffix(String name, int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}

	public String name() {
		return name;
	}

	public int attack() {
		return attack;
	}

	public int defense() {
		return defense;
	}
}
