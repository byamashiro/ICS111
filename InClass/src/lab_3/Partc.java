package lab_3;
import java.awt.Color;


public class Partc {

	public static void main(String[] args) {
		// Setup EZ graphics system.
		EZ.initialize(500,500);

		EZ.setBackgroundColor(new Color(0,150,0));
		Color lineColor1 = new Color(255,255,0);
		Color lineColor2 = new Color(0,255,255);
		int y = 0;
		int x = 0; // initialize 0
		while(y < 500 && x < 500) { // add an "and" statement to incorporate "x" (vertical lines)
		//EZ.addLine(500,500,250,y,lineColor2,3);
		EZ.addLine(0,y,500,y,lineColor2,3);
		EZ.addLine(x,0,x,500,lineColor1,3); // Add second set of lines, but x and y are switched, also changed line color
		y+=20;
		x+=20; // iterate x as well
		}
		EZ.refreshScreen();

	}

}



/*// this effect is pretty neat, do not erase
public class Partc {

	public static void main(String[] args) {
		// Setup EZ graphics system.
		EZ.initialize(500,500);

		EZ.setBackgroundColor(new Color(0,150,0));
		Color lineColor1 = new Color(255,255,0);
		Color lineColor2 = new Color(0,255,255);
		int y = 0;
		int x = 0;
		while(y < 500 || x < 500) {
		//EZ.addLine(500,500,250,y,lineColor2,3);
		EZ.addLine(0,y,500,y,lineColor2,3);
		EZ.addLine(x,0,500,y,lineColor2,3);
		y+=20;
		x+=20;
		}
		EZ.refreshScreen();

	}

}
*/
