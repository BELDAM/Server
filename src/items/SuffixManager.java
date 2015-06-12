package items;

import org.apache.commons.csv.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class SuffixManager {
	private ArrayList<Suffix> suffices = new ArrayList<>();

	public SuffixManager() {
		try {
			loadSufficesFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRandomSuffix(Item item) {
		Suffix suffix = getRandomSuffix();
		item.addSuffix(suffix);
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
