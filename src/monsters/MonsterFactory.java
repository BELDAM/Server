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
        return new Troll(level);
    }
    public Dragon createDragon()
    {
        int groupeLevel = 5;
        int groupeSize = 5;
        int level;
        Random rand = new Random();
        level = rand.nextInt((groupeLevel+groupeSize - 3) + 2) + 3;
        return new Dragon(level);
    }
    public Manwe createManwe()
    {
        int groupeLevel = 5;
        int groupeSize = 5;
        int level;
        Random rand = new Random();
        return new Manwe(100);
    }
    
}
