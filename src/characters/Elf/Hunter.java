package characters.Elf;

import Interface.FightInterface;
import Visitors.IVisitor;
import Visitors.LevelUP;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Hunter extends ElfDecorator {

    private static final int XPtoLevel = 100;

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
            if(!character.isDead()){
                character.takeDmg(getStrength());
                if(character.isDead())
                {
                    System.out.println("setXP");
                    setXp(character.getGiveXP());
                }
            }
            else System.out.println("Your Ennemi is dead");

        } else {
            System.out.println("you are dead");
        }
    }
    @Override
    public void magicAttack(FightInterface character) {
        if (!isDead()) {
            if(!character.isDead()){
                character.takeMagicDmg(getStrength());
                if(character.isDead())
                {
                    System.out.println("setXP");
                    setXp(character.getGiveXP());
                }
            }
            else System.out.println("Your Ennemi is dead");

        } else {
            System.out.println("you are dead");
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getXp() {
        return elf.getXp();
    }

    @Override
    public void setXp(int xp) {
        elf.setXp(xp);

        elf.setXp(elf.getXp() + xp);

        System.out.println("setXPChar");
        if(elf.getXp() >= XPtoLevel*elf.getLevel()) {
            System.out.println("levelUPChar");
            accept(new LevelUP());
            elf.setXp(elf.getXp() - (XPtoLevel*elf.getLevel()));
        }
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
