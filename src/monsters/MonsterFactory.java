package monsters;

import java.util.Random;

public class MonsterFactory {

    private Random rand;

    public MonsterFactory() {
        rand = new Random();
    }

    public Troll createTroll(int groupLevel, int groupSize) {
        int level;
        level = rand.nextInt(groupLevel + groupSize + 1) + 2;
        return new Troll(level);
    }

    public Dragon createDragon(int groupLevel, int groupSize) {
        int level;
        level = rand.nextInt(groupLevel + groupSize + 1) + 3;
        return new Dragon(level);
    }

    public BlackElf createBlackElf(int groupLevel, int groupSize) {
        int level;
        level = rand.nextInt(groupLevel + groupSize + 1) + 2;
        return new BlackElf(level);
    }

    public Monster createRandomMonster(int groupLevel, int groupSize) {
        if (rand.nextDouble() < 0.1) {
            return createDragon(groupLevel, groupSize);
        } else if (rand.nextDouble() < 0.3) {
            return createBlackElf(groupLevel, groupSize);
        } else {
            return createTroll(groupLevel, groupSize);
        }
    }
}
