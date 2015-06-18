package monsters;

import items.Item;

public class DarkElf extends Monster {

    public DarkElf(int level) {
        super(level, 5, 7);
        while (items.size() < random.nextInt(2) + 2) {
            addItem(itemManager.getRandomItem());
        }
        for (Item i : items) {
            hp += i.getDefense();
        }
    }
}
