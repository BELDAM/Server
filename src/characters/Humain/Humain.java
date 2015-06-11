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
    public void magiclAttack(FightInterface character) {

    }

    @Override
    public void takeMagicDmg(int dmg) {

    }
}
