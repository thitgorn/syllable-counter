package ku.util.oo;

public abstract class State {
	public abstract void handleChar(char c);

	public void enterState() {
	}

	protected boolean isLetter(char c) {
		if (Character.isLetter(c)) {
			return true;
		} else
			return false;
	}

	protected boolean isVowelOrY(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}

	protected boolean isVowel(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}
}
