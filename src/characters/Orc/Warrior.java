package characters.Orc;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Warrior extends OrcDecorator {

    public Warrior(OrcInterface orcInterface) {
        orc = orcInterface;
    }

    @Override
    public void attack(FightInterface character) {
        //TODO implementation
    }

    @Override
    public void magicAttack(FightInterface character) {
        //TODO implementation
    }

    @Override
    public void takeMagicDmg(int dmg) {
        //TODO implementation
    }

    @Override
    public void takeDmg(int dmg) {
        //TODO implementation
    }

    @Override
    public void accept(IVisitor visitor) {
        //TODO implementation
    }

    @Override
    public boolean isDead() {
        return orc.isDead();
    }

    @Override
    public int getRage() {
        return orc.getRage();
    }

    @Override
    public void setRage(int rage) {
        orc.setRage(rage);
    }
}
