import java.awt.Color;

public class Parabola {

	public static void main(String[] args) {
		
		// initialize EZ
		EZ.initialize(500,500);
		
		// iterate horizontally pixel by pixel and draw a parabola with small dots using function, f
		int i = 0;
		while (i <= 500) { // while loop to run for every x value, i, in the range of x=0 to x=500, including x=500
			int x = i; // assign values of i to x
			int y = f(i); // calls the function "f" with the iterated values of integer i
			
			EZ.addCircle(x, y, 2, 2, Color.black, true); // make circles at every step of 1 of the function using x and y
			i++;
		}
		
	}
	
	public static int f(int x) {
		int out = (x*x) /100; // the given parabola function y=m^2 / 100
		return out; // returns the y value when taking the input int x
	}
	
}
