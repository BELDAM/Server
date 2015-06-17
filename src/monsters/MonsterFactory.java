package monsters;

import java.util.Random;

/**
 *
 * @author Simon
 */
public class MonsterFactory {

    private Random rand;

    public MonsterFactory() {
        rand = new Random();
    }

    public Troll createTroll(int groupeLevel, int groupeSize) {
        int level;
        level = rand.nextInt((groupeLevel + groupeSize - 2) + 1) + 2;
        return new Troll(level);
    }

    public Dragon createDragon(int groupeLevel, int groupeSize) {
        int level;
        level = rand.nextInt((groupeLevel + groupeSize - 3) + 2) + 3;
        return new Dragon(level);
    }

    public BlackElf createBlackElf(int groupeLevel, int groupeSize) {
        int level;
        level = rand.nextInt((groupeLevel + groupeSize - 2) + 1) + 2;
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
