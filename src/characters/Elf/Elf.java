package characters.Elf;

/**
 * Created by bastiangardel on 21.05.15.
 */
public class Elf extends characters.Character implements ElfInterface {

    int speed;
    static final int SPEED = 3;

    public Elf(String name, char symbol) {
        super(name, symbol);
        speed = SPEED;
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
