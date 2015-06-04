/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import java.util.Random;
/**
 *
 * @author Simon
 */
public class MonsterFactory {
    private Object rand;

    public MonsterFactory() {
    }
    Troll createTroll()
    {
        int groupeLevel = 5;
        int groupeSize = 5;
        int level;
        Random rand = new Random();
        level = rand.nextInt((groupeLevel+groupeSize - 2) + 1) + 2;
        int HP = 5;
        int strength = 10;
        int intelligence = 3;
        int magicalDefence = 2;
        int physicalDefance = 2;
        
        
        HP += HP * (level/3);
        strength += strength * (level/2);
        physicalDefance += physicalDefance * (level/3);
        magicalDefence += magicalDefence * (level/5);
        
        return new Troll(HP, "Troll", strength, intelligence, magicalDefence ,physicalDefance, level);
    }
    
}
