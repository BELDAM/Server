package characters.Elf;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class MageElf extends ElfDecorator {

    public MageElf(ElfInterface elfInterface) {
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
    public void takeDmg(int dmg) {
        int dmgTaken = dmg - elf.getPhysicalDefence();
        if(dmgTaken <= 0)
            dmgTaken = 0;
        setHP(getHP()-dmgTaken);
        if (getHP() <= 0) {
            setHP(0);
            setDead(true);
        }
    }
    public void takeMagicDmg(int dmg){
        int dmgTaken = dmg - elf.getMagicalDefence();
        if(dmgTaken <= 0)
            dmgTaken = 0;
        setHP(getHP()-dmgTaken);
        if (getHP() <= 0) {
            setHP(0);
            setDead(true);
        }
    }

    @Override
    public void attack(FightInterface character) {
        if (!isDead()) {
            character.takeDmg(getStrength());
        } else {
            System.out.println("you are dead");
        }
    }
    @Override
    public void magicAttack(FightInterface character) {
        if (!isDead()) {
            character.takeDmg(getIntelligence());
        } else {
            System.out.println("you are dead");
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        //visitor.visit(this);
    }

    @Override
    public int getXp() {
        return 0;
    }

    @Override
    public void setXp(int xp) {

    }

    @Override
    public int getGiveXP() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return elf.isDead();
    }

    @Override
    public int getHP() {
        return elf.getHP();
    }

    @Override
    public void setHP(int HP) {
        elf.setHP(HP);
    }

    @Override
    public int getLevel() {
        return elf.getLevel();
    }

    @Override
    public void setLevel(int level) {
        elf.setLevel(level);
    }

    @Override
    public void setDead(boolean dead) {
        elf.setDead(dead);
    }

    @Override
    public int getStrength() {
        return elf.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        elf.setStrength(strength);
    }

    @Override
    public int getIntelligence() {
        return elf.getIntelligence();
    }

    @Override
    public void setIntelligence(int intelligence) {
        elf.setIntelligence(intelligence);
    }

    @Override
    public int getPhysicalDefence() {
        return elf.getPhysicalDefence();
    }

    @Override
    public void setPhysicalDefence(int physicalDefence) {
        elf.setPhysicalDefence(physicalDefence);
    }

    @Override
    public int getMagicalDefence() {
        return elf.getMagicalDefence();
    }

    @Override
    public void setMagicalDefence(int magicalDefence) {
        elf.setMagicalDefence(magicalDefence);
    }

}