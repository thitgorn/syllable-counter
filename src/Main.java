import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ku.util.oo.WordCounter;

public class Main {
	public static void main(String[] args) {
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = null;
		InputStream input = null;
		try {
			url = new URL(DICT_URL);
			input = url.openStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(url == null || input ==null){
			System.out.println("null");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		int count = 0;
		List<String> word_line = new ArrayList<>();
		try {
			for( count = 0; true ; count++){
				String word = reader.readLine();
				if(word==null){
					break;
				}
				word_line.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count_syllables = 0;
		WordCounter counter = new WordCounter();
		for(String st : word_line){
			count_syllables+=counter.countSyllables(st);
		}
		System.out.println("word = " + count);
		System.out.println("syllable = " + count_syllables);
	}
}
