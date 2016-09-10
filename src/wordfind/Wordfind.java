package wordfind;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import board.Board;
import board.Path;
import board.Square;
import board.SquareImpl;
import dict.Dictionary;
import dict.HashDict;
import board.ArrayBoard;
import board.ListPath;

public class Wordfind {

	private static class MissingLettersException extends Exception {
		private static final long serialVersionUID = 5449543806455638200L;

	}

	private static void usage(String string) {
		System.out.println("Error: " + string);
		System.out.println("Usage: java wordfind dictpath [width height [letters]");

	}
	
	private static String getLetters() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter board contents as a single string (use spaces to represent blanks): ");
		String val = br.readLine();
		System.out.println();
		br.close();
		return val;
	}

	public static void main(String[] args) throws IOException {
		int width;
		int height;
		String letters;
		if (args.length == 0) {
			usage("No arguments passed");
			return;
		}
		Dictionary dict; 
		try {
			dict = createDictionary(args[0]);
		} catch(FileNotFoundException e) {
			usage("Dictionary file not found");
			return;
		}
		if (args.length == 1) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter board width: ");
			width = scanner.nextInt();
			System.out.print("Please enter board height: ");
			height = scanner.nextInt();
			letters = getLetters();
			scanner.close();
		} else if (args.length == 3) {
			width = Integer.parseInt(args[1]);
			height = Integer.parseInt(args[2]);
			letters = getLetters();
		} else if (args.length == 4) {
			width = Integer.parseInt(args[1]);
			height = Integer.parseInt(args[2]);
			letters = args[3];
		} else {
			usage("Invalid number of arguments");
			return;
		}
		Board board;
		try {
			board = new ArrayBoard<SquareImpl>(width, height, parseLetters(letters));
		} catch (MissingLettersException | IllegalArgumentException e) {
			usage("Invalid letter string");
			return;
		}
		Collection<String> words = findWords(board, dict);
		for (String word : words) {
			System.out.println(word);
		}
	}

	private static Iterable<String> parseLetters(String letters) throws MissingLettersException {
		List<String> l = new ArrayList<String>();
		if (letters.contains(",")) {
			for (String s : letters.split((","))) {
				if (s.length() == 0)
					throw new MissingLettersException();
				l.add(s);
			}
		} else {
			for (String s : letters.split(""))
				l.add(s);
		}
		return l;
	}

	private static Dictionary createDictionary(String string) throws IOException {
		Dictionary d = new HashDict();
		try (BufferedReader br = new BufferedReader(new FileReader(string))) {
			for (String line; (line = br.readLine()) != null; ) {
				d.addWord(line);
			}
		}
		return d;
	}

	public static Collection<String> findWords(Board board, Dictionary dict) {
		Set<String> words = new HashSet<String>();
		for (Square s : board) {
			Path p = new ListPath(s);
			words.addAll(findWordsHelper(board, dict, p));
		}
		return words;
	}

	private static Collection<? extends String> findWordsHelper(Board board, Dictionary dict, Path p) {
		Set<String> words = new HashSet<String>();
		if (dict.contains(p.toString()))
			words.add(p.toString());

		for (Square s : board.getNeighbors(p.peek())) {
			if (!p.contains(s)) {
				p.push(s);
				if (dict.startOfWord(p.toString()))
					words.addAll(findWordsHelper(board, dict, p));
				p.pop();
			}
		}
		return words;
	}

}
