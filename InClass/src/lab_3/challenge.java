package lab_3;
import java.awt.Color;
import java.lang.Math;

public class challenge {

	public static void main(String[] args) {
		// Setup EZ graphics system.
		//EZ.initialize(1000,1000);
		EZ.initialize(800,800);

		EZ.setBackgroundColor(new Color(0,150,0));
		Color lineColor1 = new Color(255,255,0);
		// Color lineColor2 = new Color(0,255,255);
		int angle = 0;
		int radius = 400;
		// int y = 0;
		// int x = 0;
		
		
		
		while(angle < 175) { // while loop to iterate from 1 - 180 deg at pi/12 intervals, 175 is used so overlapping doesnt happen
			//EZ.addLine(500,500,250,y,lineColor2,3);
			// int X = (int) (Math.cos(angle) * radius); //finding a point on a circle, this isnt used with the final product
			// int Y = (int) (Math.sin(angle) * radius);
			
			
			// System.out.println(X);
			EZLine circ = EZ.addLine(400, 0, 400, radius*2 ,lineColor1,3); // start off with an initial angle 0deg with a 400 pixel radius
			circ.rotateTo(angle); // rotate by pi/12
			
			
			// works kind of for now
			// EZLine circ = EZ.addLine(0, 0, X, Y,lineColor2,3);
			// circ.translateTo(500, 500);

			
			//EZLine circ = EZ.addLine(x1, y1, x2, y2, c)
			//circ.rotateTo(y * ( Math.PI / 12 ));
			
			// EZ.addLine(, y1, x2, y2, c)
			
			angle += Math.toDegrees( Math.PI/12 );//  Approximates to 15degrees, but intervals specified to pi/12
			// y += 1;
			// x+=20;
		}
		EZ.refreshScreen();

	}

}
