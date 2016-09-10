package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPath implements Path {
	
	List<Square> l = new ArrayList<Square>();

	public ListPath(Square s) {
		l.add(s);
	}

	@Override
	public Iterator<Square> iterator() {
		return l.iterator();
	}

	@Override
	public boolean contains(Square square) {
		return l.contains(square);
	}

	@Override
	public void push(Square square) {
		l.add(square);
	}

	@Override
	public Square pop() {
		return l.remove(l.size() - 1);
	}

	@Override
	public Square peek() {
		return l.get(l.size() - 1);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Square s : l)
			sb.append(s.getLetters());
		return sb.toString();
	}

}
