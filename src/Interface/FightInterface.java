package Interface;

import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public interface FightInterface {

    void attack(FightInterface character);
    public void magicAttack(FightInterface character);
    public void takeMagicDmg(int dmg);
    void takeDmg(int dmg);

    public boolean isDead();

    public int getHP();

    public void setHP(int HP);

    public int getLevel();

    public void setLevel(int level);

    public void setDead(boolean dead);

    public int getStrength();

    public void setStrength(int strength);

    public int getIntelligence();

    public void setIntelligence(int intelligence);

    public int getPhysicalDefence();

    public void setPhysicalDefence(int physicalDefence);

    public int getMagicalDefence();

    public void setMagicalDefence(int magicalDefence);

    void accept(IVisitor visitor);

    public int getXp();

    public void setXp(int xp);

    public int getGiveXP();

}
