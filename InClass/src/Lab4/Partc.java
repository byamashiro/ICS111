
package Lab4;
import java.awt.Color;


public class Partc {
	
	public static void drawCircles(int x, int y, int r, int count) { // the input parameters will be int values of (x, y, r, c)
		int c = 0; // initialize a counter starting at 0
		
		EZ.initialize(x + count*2*r - r, y+r); // initialize the window size (x + count*2*r - r, y+r), before calling the code to make circles
		
		while( c < count) { // for the amount of counts, create as many circles, keep making circles until reaching counts
			EZ.addCircle(x + 2*c*r, y, 2*r, 2*r, Color.blue, true); // create circles of a specific radius and for each iteration, space them by a factor of 2*c*r

			c++; //increment the counter by 1
		}
	}
	
	public static void main(String[] args) {
		// initial parameters
		int xStart = 50;
		int yStart = 70;
		int radius = 20;
		int circleCount = 15;
		
		
		drawCircles(xStart, yStart, radius, circleCount); // pass the parameters for (x, y, r, count)
	}

}
