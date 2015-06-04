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
public class ElfNoir extends Monster{

    public ElfNoir(int HP, String name, int strength,int intelligence, int physicalDefence,int magicalDefence, int level) {
        super(HP, name, strength,intelligence, physicalDefence, magicalDefence, level);
        Item arme = new Item("Bow", BodyPart.RIGHT_HAND, 3, 1);
        Item legs = new Item("soft pants", BodyPart.LEGS, 0, 1);
        Item cheast = new Item("soft cheast", BodyPart.LEGS, 0, 1);
        items.add(arme);
        items.add(legs);
        items.add(cheast);
    }  
}
