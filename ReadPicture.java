import acm.program.*;
import acm.graphics.*;

public class ReadPicture extends ConsoleProgram {
	
	public void run(){
		GImage image = new GImage("Milkmaid.gif");
		image.scale(1.0);
		add(image, 0, 0);
	}

}
