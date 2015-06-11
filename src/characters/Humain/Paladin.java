package characters.Humain;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Paladin extends HumainDecorator {

    public Paladin(HumainInterface humainInterface) {
        humain = humainInterface;
    }

    @Override
    public void attack(FightInterface character) {

    }

    @Override
    public void magicAttack(FightInterface character) {

    }

    @Override
    public void takeMagicDmg(int dmg) {

    }

    @Override
    public void takeDmg(int dmg) {

    }

    @Override
    public void accept(IVisitor visitor) {
        //TODO implementation
    }

    @Override
    public boolean isDead() {
        return false;
    }

}
