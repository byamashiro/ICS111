package Challenge;

import java.util.Random;

public class GameObject {
	
	// create a static final random generator rg
	final static Random rg = new Random();
	
	// Member variables
	EZImage image;
	int speed;
	int points;
	boolean active;
	
	int x;
	int y;
	
	// Constructor
	GameObject() {
		// set speed to a random value between 1 and 4
		
		// set x to a random number between 0 and 600
		
		// set y to a random number between -600 and 0
		
		// set points to 0
		
		// set active to true
		
	}
	
	// Member functions
	void go() {
		// If object is active, advance y by speed amount and translate image to x, y
		
	}
	
	int interact(){
		// if mouse released and its position is on image, move the image to -100, -100
		// set active to false and return points
		
		// else return 0
		
		
	}
	
}
