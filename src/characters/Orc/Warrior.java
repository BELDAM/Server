package characters.Orc;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Warrior extends OrcDecorator {

    public Warrior(OrcInterface orcInterface) {
        orc = orcInterface;
    }

    @Override
    public void attack(FightInterface character) {

    }

    @Override
    public void takeDmg(int dmg) {

    }

    @Override
    public void die() {

    }
}
