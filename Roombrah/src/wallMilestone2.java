import java.awt.Color;

import java.io.FileReader;
import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.*;
import java.util.Arrays;
// import org.apache.commons.lang.ArrayUtil;
import org.apache.commons.*;
import org.apache.commons.lang3.ArrayUtils; 


// Milestone 2
public class wallMilestone2 {
	
	// Initialized variables
	static EZSound applauseSound;
	static EZSound wallSound;
	static EZSound diamondSound;

	static int counter = 0; // a global counter for amount of wall blocks, used in milestone 2
	static int counterDiamond = 0; // a global counter for amount of diamond blocks, used in milestone 2
	static int counterNull = 0; // a global counter for amount of diamond blocks, used in milestone 2
	static int counterCirc = 0;
	static int counterDiamondNull = 0;

	static int[] countElements = new int[4]; // initialize counter array for walls and dirt patches
	
	
	static void soundsEZ() { // function for loading sound files
		applauseSound = EZ.addSound("applause.wav");
		wallSound = EZ.addSound("stone1.wav");
		diamondSound = EZ.addSound("glass1.wav");
	}
	
	// function to count the total number of each type of block
	static int[] countBlock() throws java.io.IOException { // this function is used only for counting number of elements
		Scanner fileScanner = new Scanner(new FileReader("level.txt")); // load the .txt file that contains the level
		int width = fileScanner.nextInt(); // initialize with width using the first integer of the first line...
		int height = fileScanner.nextInt(); // ... second integer of the first line
		String inputText = fileScanner.nextLine(); // read in all subsequent characters after the first line

		for(int row = 0; row < height; row++){ // get the count of wall blocks
			inputText = fileScanner.nextLine(); 
			for (int column = 0; column < inputText.length(); column++){
				char ch = inputText.charAt(column);
				switch(ch){
					case 'W':
						countElements[0]++; // for every wall element, add 1 to the wall counter in the array
						break;	
					case 'D':
						countElements[1]++; // for every dirt element, add 1 to the dirt counter in the array
						countElements[3]++;
						break;
					default:
						countElements[2]++;
						countElements[3]++;
						break; // if not either a wall or dirt, then just continue on
				}
			} 
		}
		fileScanner.close();
		return new int[] {countElements[0], countElements[1], countElements[2], countElements[3]}; // return the array elements after counting through the entire map
	}
	
	
	
	public static void main(String[] args) throws java.io.IOException {
		soundsEZ(); // load sounds
		
		int directionX = 1;		// Stores the x direction of the probe
		int directionY = 1;		// Stores the y direction of the probe
		
		int countBlocks[] = countBlock(); // use the function to load the array into the main function
		int countWall = countBlocks[0]; // from the array, assign the total number of wall blocks into a variable in the main
		int countDiamond = countBlocks[1];
		int countNull = countBlocks[2];
		int countDiamondNull = countBlocks[3];

		int diamondRemainder = countDiamond; // store the number of remaining diamonds
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt")); // load the level from a .txt file

		int width = fileScanner.nextInt(); // store the width from the first int from the loaded file
		int height = fileScanner.nextInt(); // store the length from the second int from the loaded file
		String inputText = fileScanner.nextLine(); // put the cursor at the start of the strings that will be the layout

		EZ.initialize(width*32,height*32); // initialize an EZ canvas with the input width and height
		EZ.setBackgroundColor(new Color(0, 0,0)); // set the background color to black
		
		// EZImage probePicture = EZ.addImage("probe.png", 0,0);
		// probePicture.scaleBy(0.5); // originally at 0.3
		
		roombrah roomba = new roombrah("probe.png",200,100); // create a roombrah object with the image and respective position
		roomba.resize(); // resizes the roomba
		
		// initialize arrays for the blocks
		EZImage[] wallBlock = new EZImage[countWall];
		EZImage[] diamondBlock = new EZImage[countDiamond];
		// EZRectangle[] nullBlock = new EZRectangle[countNull]; // these arrays were used for the AI portion
		// EZRectangle[] diamondnullBlock = new EZRectangle[countDiamondNull];
		
				
		for(int row = 0; row < height; row++){ // for the rows and columns, make the layout with the respective blocks
			inputText = fileScanner.nextLine();
			
			for (int column = 0; column < inputText.length(); column++){
				char ch = inputText.charAt(column);
				switch(ch){ // switch the respective characters into EZ images, either walls or diamonds
					case 'W':
						wallBlock[counter] = EZ.addImage("wall.png",column*32+16,row*32+16);
						// System.out.println("wall center: " + wallBlock[counter].getWorldXCenter() + ", " + wallBlock[counter].getWorldYCenter());
						counter++;
						break;	
						
					case 'D':
						diamondBlock[counterDiamond] = EZ.addImage("diamond.png", column*32+16, row*32+16);
						// diamondnullBlock[counterDiamondNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.blue, false);
						// EZ.addImage("diamond.png",column*32,row*32);
						counterDiamond++;
						counterDiamondNull++;
						break;

					default:
						// nullBlock[counterNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.gray, true);
						// diamondnullBlock[counterDiamondNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.blue, false);
						counterNull++;
						counterDiamondNull++;
						break;
							
				}
			} 
		}
		
		fileScanner.close();
		// Print number of wall blocks and diamond blocks (diamond and dirt are used for the same element)
		System.out.println("Dimensions: " + width + " x " + height + " Total Blocks: " + (width*height));
		System.out.println("Total number of wall blocks: " + countWall);
		System.out.println("Total number of diamond blocks: " + countDiamond);
		System.out.println("Total number of null blocks: " + countNull);
		System.out.println("Total Discovery: " + (countWall+countDiamond+countNull));
		

		while(diamondRemainder > 0){
			counterCirc++;

			int posX = roomba.getX() + directionX; // store position of roomba with the respective change in direction
			int posY = roomba.getY() + directionY;
			
			// probePicture.pullToFront();
			roomba.front(); // pull the image to the front
			
			if (counterCirc == 5) { // 
				EZ.addCircle(roomba.getX(), roomba.getY(), roomba.getWidth(), roomba.getHeight(), new Color(224, 224, 224, 10), true).pushToBack(); // make a circle for every 5 move intervals of the roomba
				counterCirc = 0;
			}
			
			roomba.translate(posX, posY); //probePicture.translateTo(posX, posY); // Set the position of the probe.
			
			for (int i = 0; i < diamondBlock.length; i++) { // if a diamond is touched, play a sound and move the diamond off the layout
				if (diamondBlock[i].isPointInElement(roomba.getX(), roomba.getY())) {
					diamondSound.play();
					diamondBlock[i].translateTo(0, 0);
					diamondRemainder--;
					System.out.println(diamondRemainder + " Diamonds Remaining.");
				}
			}
			

			for (int i = 0; i < wallBlock.length; i++ ) { // Collision interactions, if the roomba is touching (-1) a wall block, change the respective directions, but also account for if the roomba hits a corner perfectly, play sound if collision occurs
				// diagonal collisions
				if (wallBlock[i].isPointInElement(roomba.getX()+1, roomba.getY()) && wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()-1)) {
					directionY = -directionY; // quadrant 1
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()-1) && wallBlock[i].isPointInElement(roomba.getX()-1, roomba.getY())) {
					directionY = -directionY; // quadrant 2
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(roomba.getX()-1, roomba.getY()) && wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()+1)) {
					directionY = -directionY; // quadrant 3
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()+1) && wallBlock[i].isPointInElement(roomba.getX()+1, roomba.getY())) {
					directionY = -directionY; //quadrant 4
					directionX = -directionX;
					wallSound.play();
				}
				
				// top, bottom, left, right
				else if (wallBlock[i].isPointInElement(roomba.getX()+1, roomba.getY()) || wallBlock[i].isPointInElement(roomba.getX()-1,roomba.getY())) {
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()+1) || wallBlock[i].isPointInElement(roomba.getX(), roomba.getY()-1)) {
					directionY = -directionY;
					wallSound.play();
				}
				
				
				


			
			}
			EZ.refreshScreen();
			
		}
		
		
		applauseSound.play(); // play a sound when all diamonds are collected
	}
}







/*// degree code for realistic collisions, commented in favor for point method
int[] probePointsX = new int[360];
int[] probePointsY = new int[360];

for (int i = 0; i < 360 ; i++) {
	double rad = Math.toRadians(i);
	// System.out.println("radians: " + rad);
	probePointsX[i] = (int) (probePicture.getWorldXCenter() + (16*Math.cos(rad))); // tried lower values for r, originally 17 for predictive hits
	probePointsY[i] = (int) (probePicture.getWorldYCenter() + (16*Math.sin(rad)));
	// System.out.println("probe X: " + probePointsX[i] + " probe Y: " + probePointsY[i] );
}
*/





/*
for (int j=0; j<360; j++) {
	if ( (j==0) || (j==30)  || (j==150) || (j==180) || (j==210) || (j==330) ) { // sets up points in the four quadrants
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionX = -directionX;
		}
	} else if ( (j==60) || (j==90)  || (j==120) || (j==240) || (j==270) || (j==300) ) {
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionY = -directionY;
		}
	} else if ( (j==45) || (j==135) || (j==225) || (j==315) ) {
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionY = -directionY;
			directionX = -directionX;
		}
	}
}
*/

//will create 360 points around the roomba, very slow
/*
for (int j=0; j<360; j++) {
	if ( (j>=0 && j<=45) || (j>=136 && j<=224) || (j>=316 && j<=359) ) { // change to possibly 3 points per quadrant instead
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionX = -directionX;
		}
	} else if ( (j>=46 && j<=134) || (j>=226 && j<=314) ) {
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionY = -directionY;
		}
	} else if ( (j==45) || (j==135) || (j==225) || (j==315) ) {
		if (wallBlock[i].isPointInElement(probePointsX[j], probePointsY[j])) {
			directionY = -directionY;
			directionX = -directionX;
		}
	}
}
*/

// System.out.println(wallBlock[i]);
/*
for (int j = 0; j<360; j++) {
	if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+8, probePicture.getWorldYCenter()) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter()-8, probePicture.getWorldYCenter())) {
		directionX = -directionX;
	} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+8) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-8)) {
		directionY = -directionY;				}
*/

/*//working code
if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+8, probePicture.getWorldYCenter()) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter()-8, probePicture.getWorldYCenter())) {
	directionX = -directionX;
} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+8) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-8)) {
	directionY = -directionY;
} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+8) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-8)) {
	
}
*/







/*
if (EZInteraction.isKeyDown('d')) {
	saberX+=10;
	if (saberX > 500) {
		saberX-=10;
	}
} else if (EZInteraction.isKeyDown('a')) {
	saberX-=10;
	if (saberX <= 0){
		saberX+=10;
	}
}
*/


