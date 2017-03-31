package ku.util.oo;

/**
 * Main class testing the WordCounter
 * 
 * @author Thitiwat Thongbor
 *
 */
public class OOSyllableCounter {
	/**
	 * run the word counter.
	 * 
	 * @param args
	 *            doesn't use
	 */
	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		System.out.println(counter.countSyllables("A"));
	}
}
