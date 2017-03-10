import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Launcher {

	private static Chapter getHighestScore(String location) throws MalformedURLException {
		Chapter chapter;
		Map<Float, String> chapterWordCount;
		URL chapterUrl = new URL(location);
		TextFrequency chapterTF = new TextFrequency();
		chapterWordCount = chapterTF.computeTextFrequency(chapterUrl);
		chapter = new Chapter(location, ((float) chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]),
				chapterWordCount.get(chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]));
		System.out.println(
				location + "    " + ((float) chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]) + "    "
						+ chapterWordCount.get(chapterWordCount.keySet().toArray()[chapterWordCount.size() - 1]));
		return chapter;
	}

	public static void main(String[] args) throws IOException {
		URL fileLocation = new URL(
				"https://gist.githubusercontent.com/SindhuNaydu/b6df021a88b645d13d4167ad4a95a695/raw/1b22d62f5400d0aca6ae0116e9202e9368e2d3a6/FileLocations.txt");
		Scanner sc = new Scanner(fileLocation.openStream());
		String text = "";
		ArrayList<Chapter> result = new ArrayList<Chapter>();
		while (sc.hasNext()) {
			text = sc.nextLine();
			result.add(getHighestScore(text));
		}
		Collections.sort(result);
		System.out.println("RESULT: " + result.get(result.size() - 1).getLocation()+
				"\n"+ result.get(result.size() - 1).getHighestTextFrequency() +"\n"+ result.get(result.size() - 1).getWord());
		sc.close();
	}
}