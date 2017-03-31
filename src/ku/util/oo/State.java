package ku.util.oo;

public abstract class State {
	public abstract void handleChar(char c);

	public void enterState() {
	}

	protected boolean isLetter(char c) {
		if (Character.isLetter(c)) {
			return true;
		} else if (c == '\'') {
			return true;
		}
		return false;
	}

	protected boolean isVowelOrY(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}

	protected boolean isVowel(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}
}
