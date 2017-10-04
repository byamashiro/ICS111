import java.util.Random;
import java.awt.Color;

public class Challenge {

	public static void main(String[] args) {
		
		EZ.initialize(500, 500);

		int pythag = 707; // the truncated value of sqrt(500^2 + 500^2), will be the radius used to reset the circle

		int numCircles = 10;
		EZCircle[] circArr = new EZCircle[numCircles]; // initialize a circle array of size 10
		int[] circRad = new int[numCircles]; // initialize a radius array to store the initial radius of all 10 circles

		// place circles at random location
		for(int c = 0; c < numCircles; c++) {
			circRad[c] = 50*(c+1); // store circle sizes from 50 to 500 in the radius array
			circArr[c] = EZ.addCircle(250, 250, circRad[c], circRad[c], Color.blue, false); // store circle elements in the circle array and display them centered at (250, 250) and of the stored array radii
		}
		
		while (true) {
			
			if (EZInteraction.isMouseLeftButtonDown()) { // ... when the left mouse button is held down...
				for (int i=0; i<numCircles; i++) { // ... for each of the circles in the array...
					circArr[i].scaleBy(1.2f); // ... up-scale the circle by 20%
					
					if (circArr[i].getWorldHeight() > pythag ) { // if the circle radius exceeds the radius found with pythagoreans ...
						circArr[i] = EZ.addCircle(250, 250, 50, 50, Color.blue, false);  // ... make a new circle centered at (250,250) of size 50w x 50h and store this new value in place of the radius that exceeds 707
					}

				}
			}
			
			EZ.refreshScreen();
		}
	}

}
