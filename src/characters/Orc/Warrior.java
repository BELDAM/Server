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

    }

    @Override
    public void magiclAttack(FightInterface character) {

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
        return orc.isDead();
    }

    @Override
    public int getRage() {
        return 0;
    }

    @Override
    public void setRage(int rage) {

    }
}
