package items;

import java.util.ArrayList;
import java.util.Random;

class SuffixManager {
	private ArrayList<Suffix> suffices;

	public Item addRandomSuffix(Item item) {
		Suffix suffix = getRandomSuffix();
		// Take a random suffix and add its stats
		// Visit the item to add stats

		return item; // Allow to chain
	}

	private Suffix getRandomSuffix() {
		return suffices.get(new Random().nextInt(suffices.size()));
	}
}
