package characters.Orc;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Orc extends characters.Character implements OrcInterface {

    private int rage;

    private static final int RAGE = 3;

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }


    public Orc(String name, char symbol) {
        super(name, symbol);
        rage = RAGE;
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
}
