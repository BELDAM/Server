package items;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class ItemManager {
	private ArrayList<Item> items = new ArrayList<>();

	public ItemManager() {
		try {
			loadSufficesFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Item getRandomItem() {
		Item item = items.get(new Random().nextInt(items.size()));

		SuffixManager suffixManager = new SuffixManager();

		double chances = new Random().nextDouble();
		int nbSuffices = 0;

		if (chances < 0.01) {
			nbSuffices = 3;
		} else if (chances < 0.1) {
			nbSuffices = 2;
		} else if (chances < 0.2) {
			nbSuffices = 1;
		}

		for (int i = 0; i < nbSuffices; i++) {
			suffixManager.addRandomSuffix(item);
		}

		return item;
	}

	private void loadSufficesFromFile() throws IOException {
		File csvData = new File("assets/items.csv");
		CSVParser parser = CSVParser.parse(csvData, Charset.forName("UTF-8"), CSVFormat.RFC4180);

		for (CSVRecord record : parser) {
			BodyPart bodyPart;

			try {
				bodyPart = BodyPart.valueOf(record.get(1));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				bodyPart = BodyPart.TORSO;
			}

			items.add(new Item(record.get(0), bodyPart, Integer.parseInt(record.get(2)), Integer.parseInt(record.get(3))));
		}
	}
}
