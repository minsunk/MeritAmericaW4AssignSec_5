import acm.program.*;

public class SecondLargest extends ConsoleProgram {
	public void run() {
		int largest = 0;
		int secondLargest = 0;
		int value = 0;
		
		while (true){
			value = readInt("? ");
			
			if (value ==0) {
				break;
			} else if (value >= largest) {
				secondLargest = largest;
				largest = value;
			}
		}
		println("The largest value is " + largest);
		println("The second largest value is" + secondLargest);

	}
}
