package monsters;

public class Troll extends Monster {

    public Troll(int level) {
        super(level, 7, 12);

        while (items.size() < random.nextInt(2) + 1) {
            addItem(itemManager.getRandomItem());
        }
    }
}
