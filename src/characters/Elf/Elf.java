package characters.Elf;

/**
 * Created by bastiangardel on 21.05.15.
 */
public class Elf extends characters.Character implements InterfaceElf {

    int speed;
    static final int SPEED = 3;
    public Elf(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(int speed) {

    }
}
