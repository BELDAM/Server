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
    void accept(IVisitor visitor);
    public boolean isDead();
}
