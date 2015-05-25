package characters.Orc;

import characters.CharacterFightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Orc extends characters.Character implements OrcInterface {
    public Orc(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeDammage(int dammage) {

    }

    @Override
    public void die() {

    }

    @Override
    public void attack(CharacterFightInterface character) {

    }
}
