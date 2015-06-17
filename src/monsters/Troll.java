/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import items.ItemManager;

public class Troll extends Monster {

    public Troll(int level) {
        super(level, 1);

        int maxN = 5;
        int t = 1 << (maxN); // 2^maxN
        int n = maxN - ((int) (Math.log((Math.random() * t)) / Math.log(2))); // maxN - log2(1..maxN)

        ItemManager itemManager = new ItemManager();

        while (items.size() < n + 1) {
            addItem(itemManager.getRandomItem());
        }

    }
}
