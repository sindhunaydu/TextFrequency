import java.util.*;
import java.net.*;
import java.io.*;

//Class TextFrequency calculates the Text Frequency value for each word in a document.
public class TextFrequency {
	protected Map<Float, String> computeTextFrequency(URL location) {
		Map<Float, String> wordCount = new HashMap<Float, String>();
		Map<Float, String> sortedWordCount;
		try {
			Scanner sc = new Scanner(location.openStream());
			String text = "";
			while (sc.hasNext()) {
				text += sc.nextLine();
			}
			// Punctuation marks are replaced with blank space. Each word is
			// then converted to lower case.
			String[] keys = text.replaceAll("[^a-zA-Z- ]", " ").toLowerCase().split("\\s+");
			String[] uniqueKeys;
			int count = 0, queequegCount = 0, whaleCount = 0, seaCount = 0;
			// Identify unique words from the document
			uniqueKeys = getUniqueKeys(keys);
			for (String key : uniqueKeys) {
				if (null == key) {
					break;
				}
				for (String s : keys) {
					if (key.equals(s)) {
						count++;
					}
				}
				//Calculating Text Frequency of queequeg, whale and sea in each document.
				if (key.equals("queequeg")) {
					queequegCount++;
				}
				if (key.equals("whale")) {
					whaleCount++;
				}
				if (key.equals("sea")) {
					seaCount++;
				}
				// Text Frequency and word are added to the wordCount HashMap
				wordCount.put(((float) count / keys.length), key);
				count = 0;
			}
			System.out.println("Text Frequency of queequeg is : " + ((float) queequegCount / keys.length));
			System.out.println("Text Frequency of whale is : " + ((float) whaleCount / keys.length));
			System.out.println("Text Frequency of sea is : " + ((float) seaCount / keys.length));
			sc.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// The wordCount HashMap is added to the sortedWordCount TreeMap to be
		// sorted in ascending order based on the frequency value.
		sortedWordCount = new TreeMap<Float, String>(wordCount);
		//Sorted Map is returned. 
		return sortedWordCount;
	}
	
	//getUniqueKeys() identifies duplicates. 
	private static String[] getUniqueKeys(String[] keys) {
		String[] uniqueKeys = new String[keys.length];
		uniqueKeys[0] = keys[0];
		int uniqueKeyIndex = 1;
		boolean keyAlreadyExists = false;
		for (int i = 1; i < keys.length; i++) {
			for (int j = 0; j <= uniqueKeyIndex; j++) {
				if (keys[i].equals(uniqueKeys[j])) {
					keyAlreadyExists = true;
				}
			}
			if (!keyAlreadyExists) {
				uniqueKeys[uniqueKeyIndex] = keys[i];
				uniqueKeyIndex++;
			}
			keyAlreadyExists = false;
		}
		return uniqueKeys;
	}
}
