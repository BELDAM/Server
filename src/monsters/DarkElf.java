package monsters;

public class DarkElf extends Monster {

    public DarkElf(int level) {
        super(level, 5, 7);
        while (items.size() < random.nextInt(2) + 2) {
            addItem(itemManager.getRandomItem());
        }
    }
}
