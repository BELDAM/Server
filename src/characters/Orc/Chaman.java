package characters.Orc;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Chaman extends OrcDecorator {

    public Chaman(OrcInterface orcInterface) {
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