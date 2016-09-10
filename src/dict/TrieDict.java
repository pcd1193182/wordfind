package dict;

public class TrieDict implements Dictionary {

	private static class TrieNode {
		private TrieNode[] subnodes;
		private boolean completion;

		TrieNode() {
			subnodes = new TrieNode[256];
			completion = false;
		}

		public TrieNode get(char c) {
			return subnodes[c];
		}

		public TrieNode set(char c) {
			if (subnodes[c] == null)
				subnodes[c] = new TrieNode();
			return subnodes[c];
		}

		public boolean isWord() {
			return completion;
		}

		public void setWord() {
			completion = true;
		}
	}
	
	private TrieNode root = new TrieNode();

	@Override
	public boolean startOfWord(String s) {
		TrieNode iter = root;
		for (int i = 0; i < s.length(); i++) {
			iter = iter.get(s.charAt(i));
			if (iter == null)
				return false;
		}
		return true;
	}

	@Override
	public boolean contains(String s) {
		TrieNode iter = root;
		for (int i = 0; i < s.length(); i++) {
			iter = iter.get(s.charAt(i));
			if (iter == null)
				return false;
		}
		return iter.isWord();
	}

	@Override
	public void addWord(String s) {
		TrieNode iter = root;
		for (int i = 0; i < s.length(); i++) {
			iter = iter.set(s.charAt(i));
		}
		iter.setWord();
	}

}
