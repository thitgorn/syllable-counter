package ku.util;

public class App {
	private App() {
		SimpleSyllableCounter counter = new SimpleSyllableCounter();
		int num = counter.countSyllables("next-door");
		System.out.println(num);
	}

	public static void main(String[] args) {
		new App();
	}
}
