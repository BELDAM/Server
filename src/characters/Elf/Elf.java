package characters.Elf;

import Interface.FightInterface;

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

    }

    @Override
    public void die() {

    }

    @Override
    public void attack(FightInterface character) {

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
