package ku.util;

/**
 * Main class for testing the SimpleSyllableCounter
 * 
 * @author Thitiwat Thongbor
 *
 */
public class App {
	/**
	 * constructer tester
	 */
	private App() {
		SimpleSyllableCounter counter = new SimpleSyllableCounter();
		int num = counter.countSyllables("invisible");
		System.out.println(num);
	}

	/**
	 * run it!!
	 * @param args dones not use.
	 */
	public static void main(String[] args) {
		new App();
	}
}
