package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayBoard<S extends Square> implements Board {
	
	private Square[][] arr;
	private int width;
	private int height;

	public ArrayBoard(int width, int height, Iterable<String> letters) {
		this.width = width;
		this.height = height;
		Iterator<String> iter = letters.iterator();
		arr = new Square[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (!iter.hasNext())
					throw new IllegalArgumentException();
				arr[y][x] = new SquareImpl(x, y, iter.next());
			}
		}
		if (iter.hasNext())
			throw new IllegalArgumentException();
	}
	
	private class BoardIterator implements Iterator<Square> {
		int x = 0;
		int y = 0;

		@Override
		public boolean hasNext() {
			return (x < width && y < height);
		}

		@Override
		public Square next() {
			if (x == width && y == height)
				throw new NoSuchElementException();
			Square s = arr[y][x];
			x++;
			if (x == width) {
				x = 0;
				y++;
			}
			return s;
		}
		
	}

	@Override
	public Iterator<Square> iterator() {
		return new BoardIterator();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public Iterable<Square> getNeighbors(Square square) {
		List<Square> l = new ArrayList<Square>();
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				int thisx = x + square.getX();
				int thisy = y + square.getY();
				
				if (thisx < 0 || thisx >= width || thisy < 0 || thisy >= height ||
				    arr[thisy][thisx].getLetters().equals(" ")) {
					continue;
				}
				l.add(arr[thisy][thisx]);
			}
		}
		return l;
	}

}
