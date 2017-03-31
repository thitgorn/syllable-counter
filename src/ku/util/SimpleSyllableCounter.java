package ku.util;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public class SimpleSyllableCounter {

	public int countSyllables(String word) {
		final int LastChar = word.length() - 1;
		int syllables = 0;
		char c = ' ';
		State state = State.START;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (c == '\'')
				continue; // ignore apostrophe
			switch (state) {
			case START:
				if (isVowelOrY(c)) {
					syllables++;
					state = State.SINGLE_VOWEL;
				} else if (isLetter(c)) {
					state = State.CONSONANT;
				} else if (c == '-') {
					return 0;
				} else {
					return 0;
				}
				break;
			case CONSONANT:
				if (isVowelOrY(c)) {
					if (i == LastChar && syllables == 0) {
						syllables++;
					} else if (i == LastChar && (c == 'e')) {
						// Don't count
					} else {
						syllables++;
						state = State.SINGLE_VOWEL;
					}
				} else if (isLetter(c)) {
					// Do nothing
				} else if (c == '-') {
					if (i == LastChar) {
						return 0;
					} else {
						state = State.HYPHEN;
					}
				} else {
					return 0;
				}
				break;
			case SINGLE_VOWEL:
				if (isVowel(c)) {
					state = State.MULTIVOWEL;
				} else if (isLetter(c)) {
					state = State.CONSONANT;
				} else if (c == '-') {
					if (i == LastChar) {
						return 0;
					} else {
						state = State.HYPHEN;
					}
				} else {
					return 0;
				}
				break;
			case MULTIVOWEL:
				if (isVowel(c)) {
					state = State.MULTIVOWEL;
				} else if (isLetter(c)) {
					state = State.CONSONANT;
				} else if (c == '-') {
					if (i == LastChar) {
						return 0;
					} else {
						state = State.HYPHEN;
					}
				} else {
					return 0;
				}
				break;
			case HYPHEN:
				if (isVowelOrY(c)) {
					syllables++;
					state = State.SINGLE_VOWEL;
				} else if (isLetter(c)) {
					state = State.CONSONANT;
				} else if (c == '-') {
					return 0;
				} else {
					return 0;
				}
				break;
			}
		}
		return syllables;
	}

	private boolean isLetter(char c) {
		if (Character.isLetter(c)) {
			return true;
		} else
			return false;
	}

	private boolean isVowelOrY(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'y' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}

	private boolean isVowel(char c) {
		final char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
		for (char v : vowel) {
			if (c == v) {
				return true;
			}
		}
		return false;
	}
}
