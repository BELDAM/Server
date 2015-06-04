package characters.Humain;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Mage extends HumainDecorator{

    public Mage(HumainInterface humainInterface) {
        humain = humainInterface;
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
