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
	private ArrayList<Item> items = new ArrayList<Item>();

	public ItemManager() {
		try {
			loadSufficesFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Item getRandomItem() {
		return items.get(new Random().nextInt(items.size()));
	}

	private void loadSufficesFromFile() throws IOException {
		File csvData = new File("assets/items.csv");
		CSVParser parser = CSVParser.parse(csvData, Charset.forName("UTF-8"), CSVFormat.RFC4180);

		for (CSVRecord record : parser) {
			items.add(new Item(record.get(0), Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2))));
		}
	}
}
