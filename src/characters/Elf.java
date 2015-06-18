package characters;

import characters.Character;

public class Elf extends Character {
    @Override
    public void levelUp() {
        hp += 15;
        intelligence += 10;
    }

    public Elf(String name, char symbol) {
        super(name, symbol);
        setHp(getHp() - 20);
        setIntelligence(getIntelligence() + 40);
    }
}
