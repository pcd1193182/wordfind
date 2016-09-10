package board;

public class SquareImpl implements Square {
	private int x;
	private int y;
	private String letters;
	
	SquareImpl(int x, int y, String letters) {
		this.x = x;
		this.y = y;
		this.letters = letters;
	}

	@Override
	public String getLetters() {
		return letters;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Square))
			return false;
		Square s = (Square)o;
		if (s.getX() == x && s.getY() == y && s.getLetters().equals(letters))
			return true;
		return false;
	}

	public int hashCode() {
		return x ^ y ^ letters.hashCode();
	}
}
