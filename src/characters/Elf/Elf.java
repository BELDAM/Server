package characters.Elf;

import Interface.FightInterface;
import Visitors.IVisitor;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * Created by bastiangardel on 21.05.15.
 */
public class Elf extends characters.Character implements ElfInterface {

    private int speed;
    private static final int SPEED = 3;

    public Elf(String name, char symbol) {
        super(name, symbol);
        speed = SPEED;
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

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
