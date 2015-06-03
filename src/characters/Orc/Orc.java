package characters.Orc;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Orc extends characters.Character implements OrcInterface {
    public Orc(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeDmg(int dmg) {

    }

    @Override
    public void die() {

    }

    @Override
    public void attack(FightInterface character) {

    }
}
