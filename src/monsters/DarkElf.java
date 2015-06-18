package monsters;

import items.ItemManager;

public class DarkElf extends Monster{
    public DarkElf(int level) {
        super(level, 1);
        int maxN = 5;
        int t = 1 << (maxN); // 2^maxN
        int n = maxN - ((int) (Math.log((Math.random() * t)) / Math.log(2))); // maxN - log2(1..maxN)
        System.out.println("n=" + n);
        ItemManager itemManager = new ItemManager();
        while(items.size() < n + 2) {
            addItem(itemManager.getRandomItem());
        }
    }
}
