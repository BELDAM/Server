package items;

import org.apache.commons.csv.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

class SuffixManager {
	private ArrayList<Suffix> suffices = new ArrayList<Suffix>();

	public SuffixManager() {
		try {
			loadSufficesFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Item addRandomSuffix(Item item) {
		Suffix suffix = getRandomSuffix();
		item.accept(this);
		// Take a random suffix and add its stats
		// Visit the item to add stats

		return item; // Allow to chain
	}

	public void visit(Item item) {
		System.out.println("Visiting " + item);
	}

	private Suffix getRandomSuffix() {
		return suffices.get(new Random().nextInt(suffices.size()));
	}

	private void loadSufficesFromFile() throws IOException {
		File csvData = new File("assets/suffices.csv");
		CSVParser parser = CSVParser.parse(csvData, Charset.forName("UTF-8"), CSVFormat.RFC4180);

		for (CSVRecord record : parser) {
			suffices.add(new Suffix(record.get(0), Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2))));
		}
	}
}
