package characters.Orc;

import Interface.FightInterface;
import Visitors.IVisitor;
import Visitors.LevelUP;
import characters.Character;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Warrior extends OrcDecorator {

    public Warrior(OrcInterface orcInterface) {
        orc = orcInterface;
    }

    @Override
    public void takeDmg(int dmg) {
        int dmgTaken = dmg - orc.getPhysicalDefence();
        if(dmgTaken <= 0)
            dmgTaken = 0;
        setHP(getHP()-dmgTaken);
        if (getHP() <= 0) {
            setHP(0);
            setDead(true);
        }
    }
    public void takeMagicDmg(int dmg){
        int dmgTaken = dmg - orc.getMagicalDefence();
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
        return orc.getXp();
    }

    public void setXp(int xp) {
        orc.setXp(xp);

        orc.setXp(orc.getXp() + xp);

        System.out.println("setXPChar");
        if(orc.getXp() >= Character.XPtoLevel*orc.getLevel()) {
            System.out.println("levelUPChar");
            accept(new LevelUP());
            orc.setXp(orc.getXp() - (Character.XPtoLevel*orc.getLevel()));
        }
    }

    @Override
    public int getGiveXP() {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public boolean isDead() {
        return orc.isDead();
    }

    @Override
    public int getHP() {
        return orc.getHP();
    }

    @Override
    public void setHP(int HP) {
        orc.setHP(HP);
    }

    @Override
    public int getLevel() {
        return orc.getLevel();
    }

    @Override
    public void setLevel(int level) {
        orc.setLevel(level);
    }

    @Override
    public void setDead(boolean dead) {
        orc.setDead(dead);
    }

    @Override
    public int getStrength() {
        return orc.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        orc.setStrength(strength);
    }

    @Override
    public int getIntelligence() {
        return orc.getIntelligence();
    }

    @Override
    public void setIntelligence(int intelligence) {
        orc.setIntelligence(intelligence);
    }

    @Override
    public int getPhysicalDefence() {
        return orc.getPhysicalDefence();
    }

    @Override
    public void setPhysicalDefence(int physicalDefence) {
        orc.setPhysicalDefence(physicalDefence);
    }

    @Override
    public int getMagicalDefence() {
        return orc.getMagicalDefence();
    }

    @Override
    public void setMagicalDefence(int magicalDefence) {
        orc.setMagicalDefence(magicalDefence);
    }

    @Override
    public int getRage() {
        return orc.getRage();
    }

    @Override
    public void setRage(int rage) {
        orc.setRage(rage);
    }

    @Override
    public char getSymbol() {
        return orc.getSymbol();
    }

    @Override
    public String getName() {
        return orc.getName();
    }
}
