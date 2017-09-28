import java.awt.Color;


public class BugRunFunced {

	
	static int posX = 0;
	static int posY = 200;
	static EZImage bugPicture;

	static void setup() {
		
		// Setup EZ graphics system.
		EZ.initialize(500,500);  // PIXEL picture element 

		
		EZ.setBackgroundColor(new Color(0,150,0)); 

		
		// Load a picture of a bug from the file.
		// Make a variable called bugPicture of type EZImage.
		// Put inside the bugPicture variable, a picture from the file "bug.png"
	
		bugPicture = EZ.addImage("bug.png", 0,0);
		// Make a variable called bugPicture of type EZImage and store in it
		// an image whose filename is "bug.png" and put that picture at location 0,0
		
		// Use to keep track of X position of bug.
		int posX = 0;
		int posY = 200;


	}
	
	static void run() {
		while(true) {
			bugPicture.translateTo(posX,posY);
			bugPicture.rotateTo(posX);
			posX = posX + 1;
			System.out.println(posX);
			EZ.refreshScreen();
		}
	}

	public static void main(String[] args) {

			setup();
			
			run();
	}

}
