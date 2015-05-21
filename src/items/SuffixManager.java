package items;

import org.apache.commons.csv.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
		// Take a random suffix and add its stats
		// Visit the item to add stats

		return item; // Allow to chain
	}

	private Suffix getRandomSuffix() {
		return suffices.get(new Random().nextInt(suffices.size()));
	}

	public void loadSufficesFromFile() throws IOException {
		URL location = SuffixManager.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(location.getFile());

		File csvData = new File("assets/suffices.csv");
		CSVParser parser = CSVParser.parse(csvData, Charset.forName("UTF-8"), CSVFormat.RFC4180);

		for (CSVRecord record : parser) {
			suffices.add(new Suffix(record.get(0), Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2))));
		}
	}
}
