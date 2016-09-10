package board;

public interface Board extends Iterable<Square> {
	/*
	 * Return the width of the board
	 */
	int getWidth();
	/*
	 * Return the height of the board
	 */
	int getHeight();
	/*
	 * Return the neighbors of the given square
	 */
	Iterable<Square> getNeighbors(Square square);
}
