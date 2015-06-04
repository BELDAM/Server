package Interface;

import items.Item;

/**
 * Created by bastiangardel on 25.05.15.
 */
public interface FightInterface {

    void attack(FightInterface character);
    void takeDmg(int dmg);
    public boolean isDead();
}
