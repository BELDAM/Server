package characters.Elf;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Hunter extends ElfDecorator {

    public Hunter(ElfInterface elfInterface) {
        elf = elfInterface;
    }

    @Override
    public int getSpeed() {
        return elf.getSpeed();
    }

    @Override
    public void setSpeed(int speed) {
        elf.setSpeed(speed);
    }

    @Override
    public void attack(FightInterface character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO implementation
    }

    @Override
    public void takeDmg(int dmg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO implementation
    }

    @Override
    public void accept(IVisitor visitor) {

    }

    @Override
    public boolean isDead() {
        return elf.isDead();
    }

}
