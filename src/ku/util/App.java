package ku.util;

public class App {
	private App() {
		SimpleSyllableCounter counter = new SimpleSyllableCounter();
		int num = counter.countSyllables("invisible");
		System.out.println(num);
	}

	public static void main(String[] args) {
		new App();
	}
}
