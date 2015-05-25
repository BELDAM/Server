package characters.Elf;

import characters.CharacterFightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public abstract interface ElfInterface extends CharacterFightInterface {

    public int getSpeed();

    public void setSpeed(int speed);

}
