
import acm.program.*;
import acm.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {
	
	public void run() {
		initHistogram();
		readScoresIntoHistogram();
		printHistogram();
	}
	
/** 
 * Create Histogram with array[11]
 * Read MidtermScores file
 * count them according to the score range
 * use '*' to show how many belong to each range
 */
	
	//Create Histogram with array[11]
	private void initHistogram(){
		histogramArray = new int[11];
		for (int i = 0; i <= 10; i++) {
			histogramArray[i] = 0;
		}
	}
	/*Read the exam scores, updating the histogram */
	public void readScoresIntoHistogram() {
		try {
			BufferedReader rd 
				= new BufferedReader(new FileReader("MidtermScores.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int score = Integer.parseInt(line);
				if (score < 0 || score > 100) {
					throw new ErrorException("That score is out of range");
				} else {
					int range = score / 10;
					histogramArray[range]++;
				}
			}
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	/*Displays the histogram*/
	private void printHistogram() {
		for (int range = 0; range <= 10; range++) {
			String label;
			switch (range) {
				case 0:
					label = "00-09";
					break;
				case 10:
					label = "  100";
					break;
				default:
					label = (10 * range) + "-" + (10 * range + 9);
					break;
			}
			String stars = createStars(histogramArray[range]);
			println(label + ": " + stars);
		}
	}
	/* Creates a string consisting of n stars */
	private String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";
		}
		return stars;
	}
	/* Private instance variables */
	private int[] histogramArray;
	

}
