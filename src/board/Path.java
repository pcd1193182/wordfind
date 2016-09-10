package board;

public interface Path extends Iterable<Square> {
	boolean contains(Square square);
	void push(Square square);
	Square pop();
	Square peek();
	String toString();
}
