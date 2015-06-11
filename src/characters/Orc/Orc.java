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

    }

    @Override
    public void accept(IVisitor visitor) {

    }

    @Override
    public void attack(FightInterface character) {

    }
}
