/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import items.BodyPart;
import items.Item;

/**
 *
 * @author Simon
 */
public class Troll extends Monster{

    public Troll(int HP, String name, int strength, int defense, int level) {
        super(HP, name, strength, defense, level);
        Item arme = new Item("Gourdin", BodyPart.RIGHT_HAND, 2, 1);
        Item armure = new Item("pagne", BodyPart.LEGS, 0, 1);
        items.add(arme);
        items.add(armure);
    }
    
    
}
