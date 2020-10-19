/*
 * Fie: WordCount.java
 * --------------------
 * Counts the characters, words, and lines in a file.
 */
import acm.program.ConsoleProgram;


import java.io.*;
public class WordCount extends ConsoleProgram {
	public void run() {
		int lines = 0;
		int words = 0;
		int chars =0;
		BufferedReader rd = openFileReader("File: ");
		//BufferedReader rd = new BufferedReader(new Filedreader(lear.txt))
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lines++;
				words += countWords(line);
				chars += line.length();
			}
			rd.close();
		} catch (IOException ex) {
			println("An I/O exception has occured");
		}
		println("Lines = " + lines);
		println("words = " + words);
		println("chars = " + chars);
	}
/**
 * Asks the user for the name of an input file and returns a 
 * BufferedReader attached to its contenst. If the file does not exist,
 * the user is given another chance to try.
 */
	private BufferedReader openFileReader(String prompt){
		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(readLine(prompt)));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
/**
 * Counts the words (consecutive strings of letters and/or digits)
 * in the input line.
 */
	private int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) words++;
				inWord = false;
			}
		}
		if (inWord) words++;
		return words;
	}
	
}