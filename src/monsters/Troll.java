/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Visitors.IVisitor;
import Visitors.init;
import items.ItemManager;

/**
 *
 * @author Simon
 */
public class Troll extends Monster {

    public Troll(int level) {
        super(level);
        //http://stackoverflow.com/questions/3745760/java-generating-a-random-numbers-with-a-logarithmic-distribution
        int maxN = 5;
        int t = 1 << (maxN); // 2^maxN
        int n = maxN - ((int) (Math.log((Math.random() * t)) / Math.log(2))); // maxN - log2(1..maxN)
        System.out.println("n=" + n);
        ItemManager itemManager = new ItemManager();
        //while (items.size() < n + 2) {
            addItem(itemManager.getRandomItem());
        //}

        for(int i = 0; i < items.size(); i++)
        {
            this.strength += items.get(i).getAttack();
            this.physicalDefence += items.get(i).getDefense();
        }
        accept(new init());

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
