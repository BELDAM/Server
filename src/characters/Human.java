package characters;

import characters.Character;

public class Human extends Character {
    @Override
    public void levelUp() {
        hp += 20;
    }

    public Human(String name, char symbol) {
        super(name, symbol);
        hp += 40;
    }
}
