package dict;

import java.util.HashSet;
import java.util.Set;

public class HashDict implements Dictionary {
	
	private Set<String> set = new HashSet<String>();

	@Override
	public boolean startOfWord(String s) {
		return true;
	}

	@Override
	public boolean contains(String s) {
		return set.contains(s);
	}

	@Override
	public void addWord(String s) {
		set.add(s);
	}

}
