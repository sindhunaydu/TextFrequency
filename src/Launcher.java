import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Launcher {
	// Method to calculate and return the highest Text Frequency for each
	// document.
	private static Chapter getHighestScore(String location) throws MalformedURLException {
		Chapter chapter;
		Map<Float, String> chapterWordCount;
		URL chapterUrl = new URL(location);
		TextFrequency chapterTF = new TextFrequency();
		// computeTextFrequency() method identifies unique words, count and Text
		// Frequency.
		chapterWordCount = chapterTF.computeTextFrequency(chapterUrl);
		// TreeMap automatically sorts based on the Text Frequency in ascending
		// order. The highest value fetched and instantiated as a Chapter class.
		chapter = new Chapter(location, ((float) chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]),
				chapterWordCount.get(chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]));
		System.out.println(
				location + "    " + ((float) chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]) + "    "
						+ chapterWordCount.get(chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]));
		// Object contains highest Text Frequency information.
		return chapter;
	}

	public static void main(String[] args) throws IOException {
		// The text document URLs are saved in a separate file. The file is
		// parsed and each document is accessed to calculate Text Frequency.
		URL fileLocation = new URL(
				"https://gist.githubusercontent.com/SindhuNaydu/b6df021a88b645d13d4167ad4a95a695/raw/1b22d62f5400d0aca6ae0116e9202e9368e2d3a6/FileLocations.txt");
		Scanner sc = new Scanner(fileLocation.openStream());
		String text = "";
		ArrayList<Chapter> result = new ArrayList<Chapter>();
		// URLs are separated using the new line delimiter
		while (sc.hasNext()) {
			text = sc.nextLine();
			// The Text Frequency for each word is calculated using the
			// getHighestScore() method. The method returns document URL,
			// highest Text Frequency and its corresponding text.
			result.add(getHighestScore(text));
		}
		// The ArrayList is sorted to identify and display the document with
		// highest Text Frequency.
		Collections.sort(result);
		System.out.println("RESULT: " + result.get(result.size() - 1).getLocation() + "\n"
				+ result.get(result.size() - 1).getHighestTextFrequency() + "\n"
				+ result.get(result.size() - 1).getWord());
		sc.close();
	}
}