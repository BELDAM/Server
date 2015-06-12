package characters.Elf;

import Interface.FightInterface;
import Visitors.IVisitor;

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

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
