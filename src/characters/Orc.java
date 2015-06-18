package characters;

import characters.Character;

public class Orc extends Character {
    @Override
    public void levelUp() {
        strength += 20;
        hp += 10;
        physicalDefence += 20;
    }

    public Orc(String name, char symbol) {
        super(name, symbol);
        strength += 30;
    }
}
