package monsters;

import items.Item;

public class Dragon extends Monster {

    public Dragon(int level) {
        super(level, 50, 100);

        while (items.size() < random.nextInt(3) + 3) {
            addItem(itemManager.getRandomItem());
        }
        for (Item i : items) {
            hp += i.getDefense();
        }
    }
}
