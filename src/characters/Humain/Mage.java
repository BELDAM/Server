package characters.Humain;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Mage extends HumainDecorator{

    private int mana;
    private static final int MANA = 3;

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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
