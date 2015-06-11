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
    public Troll createTroll()
    {
        int groupeLevel = 5;
        int groupeSize = 5;
        int level;
        Random rand = new Random();
        level = rand.nextInt((groupeLevel+groupeSize - 2) + 1) + 2;
        int HP = 10;
        int strength = 10;
        int intelligence = 3;
        int magicalDefence = 2;
        int physicalDefence = 2;
        
        
        HP += HP * (level/3);
        strength += level * 2;
        physicalDefence += level ;
        magicalDefence += level/2;
        intelligence += level;
        
        return new Troll(HP, "Troll", strength, intelligence, magicalDefence ,physicalDefence, level);
    }
    public Dragon createDragon()
    {
        int groupeLevel = 5;
        int groupeSize = 5;
        int level;
        Random rand = new Random();
        level = rand.nextInt((groupeLevel+groupeSize - 3) + 2) + 3;
        int HP = 25;
        int strength = 15;
        int intelligence = 10;
        int magicalDefence = 12;
        int physicalDefence = 12;


        HP += level * 1.5;
        strength += level * 1.5;
        intelligence += intelligence += level;
        physicalDefence += level ;
        magicalDefence += level;

        return new Dragon(HP, "Dragon", strength, intelligence, magicalDefence ,physicalDefence, level);
    }
    
}
