/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Interface.FightInterface;
import Visitors.IVisitor;
import Visitors.init;
import items.ItemManager;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Simon
 */
public class Manwe extends Monster{
    public Manwe(int level) {
        super(level);
        init initialisation = new init();
        accept(initialisation);
        int maxN = 5;
        int t = 1 << (maxN); // 2^maxN
        int n = maxN - ((int) (Math.log((Math.random() * t)) / Math.log(2))); // maxN - log2(1..maxN)
        System.out.println("n=" + n);
        ItemManager itemManager = new ItemManager();
        while (items.size() < n + 2) {
            addItem(itemManager.getRandomItem());
        }

        for(int i = 0; i < items.size(); i++)
        {
            this.strength += items.get(i).getAttack();
            this.physicalDefence += items.get(i).getDefense();
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public void attack(FightInterface character) {
        if (!isDead()) {
            Random rand = new Random();
            int attack = rand.nextInt(100);
            if(attack > 95) {
                character.takeDmg(strength);
                if(character.isDead())
                {
                    System.out.println("Manwe slain someone.");
                }
            }
            else
            {
                System.out.println(this.name + " : Bah, i will attack tomorrow, time to 9gag or WebComics");
            }
        } else {
            System.out.println("you are dead");
        }
    }
    public void magicAttack(FightInterface character)
    {
        if (!isDead()) {
            Random rand = new Random();
            int attack = rand.nextInt(100);
            if(attack > 95) {
                character.takeMagicDmg(intelligence);
                if(character.isDead())
                {
                    System.out.println("Manwe slain someone.");
                }
            }
            else
            {
                System.out.println(this.name + " :  Bah, i will attack tomorrow, time to 9gag or WebComics");
            }
        } else {
            System.out.println("you are dead");
        }
    }

    @Override
    public LinkedList dropItem() {
        Random rand = new Random();
        float note ;
        LinkedList testMCR = new LinkedList();
        for(int i = 0 ; i < 29; i++) {
            note = rand.nextInt(51) + 10;
            testMCR.add("L eleve" + i + " a obtenu " + note/10);
        }
        return testMCR;
    }
}
