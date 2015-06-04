package characters.Orc;

import Interface.FightInterface;

import java.security.PrivateKey;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Chaman extends OrcDecorator {

    private int mana;
    private static final int MANA = 3;

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

    @Override
    public int getRage() {
        return 0;
    }

    @Override
    public void setRage(int rage) {

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
