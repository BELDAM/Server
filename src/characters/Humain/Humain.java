package characters.Humain;

import Interface.FightInterface;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Humain extends characters.Character implements HumainInterface {
    public Humain(String name, char symbol) {
        super(name, symbol);
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
}
