package ku.util.oo;

/**
 * abstract State class helping the Word converter avoid duplicate code.
 * 
 * @author Thitiwat Thongbor
 *
 */
public abstract class State {
	/**
	 * doing the State job , check the condition at the state
	 * 
	 * @param c
	 *            character to check
	 */
	public abstract void handleChar(char c);

	/**
	 * do thing when the state is started.
	 */
	public void enterState() {
	}

	/**
	 * check is this the letter of not.
	 * 
	 * @param c
	 *            character to check
	 * @return true if that is letter
	 */
	protected boolean isLetter(char c) {
		if (Character.isLetter(c)) {
			return true;
		} else if (c == '\'') {
			return true;
		}
		return false;
	}

	/**
	 * check is that the vowel or not including y [ count as vowel ]
	 * 
	 * @param c
	 *            character to check
	 * @return true if that is the vowel or y
	 */
	protected boolean isVowelOrY(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check is that the vowel
	 * 
	 * @param c
	 *            character to check
	 * @return true if that is vowel
	 */
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
