package items;

import java.io.IOException;

public class MainItems {
	public static void main(String[] args) throws IOException {
		ItemManager im = new ItemManager();
		Item item = im.getRandomItem();
		System.out.println(item);

		SuffixManager sm = new SuffixManager();
		sm.addRandomSuffix(item);
		System.out.println(item);
	}
}
