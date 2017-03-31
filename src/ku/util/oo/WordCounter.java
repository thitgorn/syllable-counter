package ku.util.oo;

/**
 * Word counter machine using OO design to count to the word.
 * 
 * @author Thitiwat Thongbor
 *
 */
public class WordCounter {
	// declare the constant first , using it as State.
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();
	private final State STOP = new StopState();
	// declare attribute
	private State state;
	private int syllableCount;
	private int cursor, LastChar;
	private String word;

	/**
	 * construct the word counter machine
	 */
	public WordCounter() {
	}

	/**
	 * count the syllable of the word
	 * 
	 * @param word
	 *            to count
	 * @return the value how many syllable
	 */
	public int countSyllables(String word) {
		syllableCount = 0;
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

	/**
	 * set the current state.
	 * 
	 * @param state
	 *            to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Start state uses the command at the state checking first character.
	 */
	class StartState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowelOrY(c)) {
				syllableCount++;
				setState(SINGLEVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(STOP);
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

	/**
	 * action for SingleVowel state it's happen when the character begin vowel
	 * or y.
	 */
	class SingleVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowel(c)) {
				setState(MULTIVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
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

	/**
	 * action for multivowel state , decide which is going next after being in
	 * this state.
	 */
	class MultiVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowel(c)) {
				setState(MULTIVOWEL);
			} else if (super.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
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

	/**
	 * A consonant state is a letter state decide what to go next.
	 */
	class ConsonantState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowelOrY(c)) {
				if (cursor == LastChar && syllableCount == 0) {
					syllableCount++;
				} else if (cursor == LastChar && (c == 'e' || c == 'E')) {

				} else {
					syllableCount++;
					setState(SINGLEVOWEL);
				}
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				if (cursor == LastChar) {
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

	/**
	 * if it is hypen (-) come to this state and action it.
	 */
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

	/**
	 * this state is not doing anything use it for stop the counter.
	 */
	class StopState extends State {
		@Override
		public void handleChar(char c) {
		}

		@Override
		public void enterState() {
		}
	}
}
