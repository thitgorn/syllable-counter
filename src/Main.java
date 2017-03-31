import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ku.util.oo.WordCounter;

/**
 * Main class running the challenge at dictionary
 * 
 * @author Thitiwat Thongbor
 *
 */
public class Main {
	public static void main(String[] args) {
		// set the url
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = null;
		InputStream input = null;
		try { // try to open the file
			url = new URL(DICT_URL);
			input = url.openStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		int count = 0;
		// add all the word to the list
		List<String> word_line = new ArrayList<>();
		try { // try to read the file
			for (; true;) {
				String word = reader.readLine();
				if (word == null) { // exit if null
					break;
				}
				word_line.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count_syllables = 0;
		WordCounter counter = new WordCounter();
		// count the syllables
		for (String st : word_line) {
			int countS = counter.countSyllables(st);
			count_syllables+= countS;
			if (countS != 0) {
				count++;
			}
		}
		// print out the result
		System.out.println("word = " + count);
		System.out.println("syllable = " + count_syllables);
	}
}
