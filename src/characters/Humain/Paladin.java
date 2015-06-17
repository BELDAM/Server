package characters.Humain;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Paladin extends HumainDecorator {

    public Paladin(HumainInterface humainInterface) {
        humain = humainInterface;
    }

    @Override
    public void takeDmg(int dmg) {
        int dmgTaken = dmg - humain.getPhysicalDefence();
        if(dmgTaken <= 0)
            dmgTaken = 0;
        setHP(getHP()-dmgTaken);
        if (getHP() <= 0) {
            setHP(0);
            setDead(true);
        }
    }
    public void takeMagicDmg(int dmg){
        int dmgTaken = dmg - humain.getMagicalDefence();
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
        return humain.getXp();
    }

    @Override
    public void setXp(int xp) {
        humain.setXp(xp);
    }

    @Override
    public int getGiveXP() {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public boolean isDead() {
        return humain.isDead();
    }

    @Override
    public int getHP() {
        return humain.getHP();
    }

    @Override
    public void setHP(int HP) {
        humain.setHP(HP);
    }

    @Override
    public int getLevel() {
        return humain.getLevel();
    }

    @Override
    public void setLevel(int level) {
        humain.setLevel(level);
    }

    @Override
    public void setDead(boolean dead) {
        humain.setDead(dead);
    }

    @Override
    public int getStrength() {
        return humain.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        humain.setStrength(strength);
    }

    @Override
    public int getIntelligence() {
        return humain.getIntelligence();
    }

    @Override
    public void setIntelligence(int intelligence) {
        humain.setIntelligence(intelligence);
    }

    @Override
    public int getPhysicalDefence() {
        return humain.getPhysicalDefence();
    }

    @Override
    public void setPhysicalDefence(int physicalDefence) {
        humain.setPhysicalDefence(physicalDefence);
    }

    @Override
    public int getMagicalDefence() {
        return humain.getMagicalDefence();
    }

    @Override
    public void setMagicalDefence(int magicalDefence) {
        humain.setMagicalDefence(magicalDefence);
    }

}
