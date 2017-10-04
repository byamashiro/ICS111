import java.util.Random;
import java.awt.Color;

public class Part3 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		EZ.initialize(500, 500);

		int numCircles = 5; // initialize an int and assign the value 5 to it
		EZCircle[] circArr = new EZCircle[numCircles]; // initialize an EZCircle array of length 5

		// from 0 to 5, assign a random x and y value and display a filled green circle of size 40w x 40h, and load each iteration to the array
		for(int c = 0; c < numCircles; c++) {
			int randX = rand.nextInt(500);
			int randY = rand.nextInt(500);
			circArr[c] = EZ.addCircle(randX, randY, 40, 40, Color.GREEN, true);
		}
		
		
		while (true) {
			// get the x and y position of the cursor
			int clickX = EZInteraction.getXMouse(); 
			int clickY = EZInteraction.getYMouse();
			
			if (EZInteraction.wasMouseLeftButtonPressed()) { // when the mouse left button is pressed...
				for (int i=0; i<numCircles; i++) { // ... for all circles in the array ...
					
					if (circArr[i].isPointInElement( clickX, clickY )) { // ... if the cursor is in the element ...
						circArr[i].scaleBy(1.2f); // ... up-scale the circle by 20%
					}

				}
			}
			
			EZ.refreshScreen();
		}
	}

}
