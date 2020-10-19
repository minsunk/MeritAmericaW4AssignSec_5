import acm.program.*;
import java.util.*;


public class UniqueNames extends ConsoleProgram {
	public void run(){
		//Make ArrayList to store name inputs
		ArrayList<String> nameList = new ArrayList<String>();
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (!nameList.contains(name)){
				nameList.add(name);
			}
		}
		
		println("Unique name list contains:");
		printList(nameList);
	}
	
	/*Prints out contents of ArrayList, one element per line */
	private void printList(ArrayList nameList){
		for(int i=0; i < nameList.size(); i++){
			println(nameList.get(i));
		}
	}
}
