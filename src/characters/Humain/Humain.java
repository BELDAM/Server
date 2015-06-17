package characters.Humain;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Humain extends characters.Character implements HumainInterface {
    public Humain(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeDmg(int dmg) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void accept(IVisitor visitor) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public int getGiveXP() {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void attack(FightInterface character) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void magicAttack(FightInterface character) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void takeMagicDmg(int dmg) {
        throw new UnsupportedOperationException("Pas disponible");
    }
}
