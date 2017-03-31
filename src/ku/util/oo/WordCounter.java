package ku.util.oo;

public class WordCounter {
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();
	private final State STOP = new StopState();
	private State state;
	private int syllableCount = 0;
	private int cursor, LastChar;
	private String word;

	public WordCounter() {
	}

	public int countSyllables(String word) {
		this.word = word;
		LastChar = word.length() - 1;
		setState(START);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(cursor) == '\'')
				continue;
			cursor = i;
			this.state.enterState();
		}
		cursor = 0;
		return syllableCount;
	}

	public void setState(State state) {
		this.state = state;
	}

	class StartState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowelOrY(c)) {
				syllableCount++;
				setState(SINGLEVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(HYPHEN);
			} else {
				syllableCount = 0;
				setState(STOP);
			}
		}

		@Override
		public void enterState() {
			handleChar(word.charAt(cursor));
		}

	}

	class SingleVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowel(c)) {
				setState(MULTIVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
					syllableCount = 0;
					setState(STOP);
				} else {
					setState(HYPHEN);
				}
			} else {
				syllableCount = 0;
				setState(STOP);
			}
		}

		@Override
		public void enterState() {
			handleChar(word.charAt(cursor));
		}
	}

	class MultiVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isLetter(c)) {
				setState(MULTIVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
					syllableCount = 0;
					setState(STOP);
				} else {
					setState(HYPHEN);
				}
			} else {
				syllableCount = 0;
				setState(STOP);
			}
		}

		@Override
		public void enterState() {
			handleChar(word.charAt(cursor));
		}
	}

	class ConsonantState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowelOrY(c)) {
				if (cursor == LastChar && syllableCount == 0) {
					syllableCount++;
				} else if (cursor == LastChar && c == 'e') {

				} else {
					syllableCount++;
					setState(SINGLEVOWEL);
				}
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
					syllableCount = 0;
					setState(STOP);
				} else {
					setState(HYPHEN);
				}
			} else {
				syllableCount = 0;
				setState(STOP);
			}
		}

		@Override
		public void enterState() {
			handleChar(word.charAt(cursor));
		}

	}

	class HyphenState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowelOrY(c)) {
				syllableCount++;
				setState(SINGLEVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else {
				syllableCount = 0;
				setState(STOP);
			}
		}

		@Override
		public void enterState() {
			handleChar(word.charAt(cursor));
		}
	}

	class StopState extends State {

		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {

		}

	}
}
