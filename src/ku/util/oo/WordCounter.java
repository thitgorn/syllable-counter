package ku.util.oo;

public class WordCounter {
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();

	class StartState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {

		}

	}

	class SingleVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (super.isVowel(c)) {
				// setState(MULTIVOWEL);
			} else if (super.isLetter(c)) {

			} else if (c == '-') {

			} else {

			}
		}

		@Override
		public void enterState() {

		}
	}

	class MultiVowelState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub
		}

		@Override
		public void enterState() {

		}
	}

	class ConsonantState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub
		}

		@Override
		public void enterState() {

		}

	}

	class HyphenState extends State {
		@Override
		public void handleChar(char c) {

		}

		@Override
		public void enterState() {

		}
	}
}
