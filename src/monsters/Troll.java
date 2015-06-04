/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import items.ItemManager;
import java.util.Random;

/**
 *
 * @author Simon
 */
public class Troll extends Monster {

    public Troll(int HP, String name, int strength, int defense, int level) {
        super(HP, name, strength, defense, level);
        Random rand = new Random();
        ItemManager itemManager = new ItemManager() ;
        int nbrDrop = rand.nextInt((3) + 1);
        while(items.size() < nbrDrop)
        {
            items.add(itemManager.getRandomItem());
        }
    }

}
