package characters.Elf;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public abstract interface ElfInterface extends FightInterface {

    public int getSpeed();

    public void setSpeed(int speed);

    public char getSymbol();

    public String getName();

}
