package board;

public interface Square {
	/*
	 * Get the letter stored in this square
	 */
	String getLetters();
	
	/*
	 * Get x coordinate of the square (indexing from 0 on the left).
	 */
	int getX();
	
	/*
	 * Get y coordinate of the square (indexing from 0 on the top).
	 */
	int getY();
}
