package dict;

public interface Dictionary {
	/*
	 * Returns true if s may be the start of a word in the dictionary.  Implementations should not rely on a word
	 * starting with s being present if true is returned, but they can rely on there being no words that start with s if
	 * false is returned.
	 */
	boolean startOfWord(String s);
	
	/*
	 * Returns true if and only if s is a word in the dictionary.
	 */
	boolean contains(String s);
	
	/*
	 * Adds a word to the dictionary.
	 */
	void addWord(String s);
}
