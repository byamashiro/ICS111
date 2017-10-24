package deprecated;

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



// STILL UNDER DEVELOPMENT AS OF 10/15/2017, NOT USED FOR MILESTONE 1.
public class roombrahRemastered_withoutclass {
	
	static EZSound applauseSound;
	static EZSound wallSound;
	static EZSound diamondSound;

	static int counter = 0; // a global counter for amount of wall blocks, used in milestone 2
	static int counterDiamond = 0; // a global counter for amount of diamond blocks, used in milestone 2
	static int counterNull = 0; // a global counter for amount of diamond blocks, used in milestone 2
	static int counterCirc = 0;
	static int counterDiamondNull = 0;


	static int[] countElements = new int[4]; // initialize counter array for walls and dirt patches
	
	
	static void soundsEZ() {
		applauseSound = EZ.addSound("applause.wav");
		wallSound = EZ.addSound("stone1.wav");
		diamondSound = EZ.addSound("glass1.wav");
	}
	
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
		soundsEZ();
		
		int posX = 200;		//0	// Stores the x position of the probe
		int posY = 100;			// Stores the y position of the probe	
		// roombrah roomba = new roombrah("probe.png", 200, 100);
		int directionX = 1;		// Stores the x direction of the probe
		int directionY = 1;		// Stores the y direction of the probe
		int rotationAngle = 0;	// Stores the rotation angle of the probe
		int saberX = 700/2;		// Stores X Position of the light saber 
		int bounces = 0;		// Stores the number of times the probe has bounced off the lightsaber
		
		
		
		int countBlocks[] = countBlock(); // use the function to load the array into the main function
		int countWall = countBlocks[0]; // from the array, assign the total number of wall blocks into a variable in the main
		int countDiamond = countBlocks[1];
		int countNull = countBlocks[2];
		int countDiamondNull = countBlocks[3];

		int diamondRemainder = countDiamond;
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));

		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();

		EZ.initialize(width*32,height*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		EZImage probePicture = EZ.addImage("probe.png", 0,0);
		probePicture.scaleBy(0.5); // originally at 0.3
		
		
		EZImage[] wallBlock = new EZImage[countWall];
		EZImage[] diamondBlock = new EZImage[countDiamond];
		EZRectangle[] nullBlock = new EZRectangle[countNull];
		EZRectangle[] diamondnullBlock = new EZRectangle[countDiamondNull];
		
		

		// System.out.println("Amount of wall blocks: " + countWall);
		
		for(int row = 0; row < height; row++){
			inputText = fileScanner.nextLine();
			// System.out.println(inputText);
			
			for (int column = 0; column < inputText.length(); column++){
				
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'W':
						wallBlock[counter] = EZ.addImage("wall.png",column*32+16,row*32+16);
						// System.out.println("wall center: " + wallBlock[counter].getWorldXCenter() + ", " + wallBlock[counter].getWorldYCenter());
						counter++;
						break;	
						
					case 'D':
						diamondBlock[counterDiamond] = EZ.addImage("diamond.png", column*32+16, row*32+16);
						diamondnullBlock[counterDiamondNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.blue, false);
						// EZ.addImage("diamond.png",column*32,row*32);
						counterDiamond++;
						counterDiamondNull++;
						break;

					default:
						// nullBlock[counterNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.gray, true);
						diamondnullBlock[counterDiamondNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.blue, false);
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

			posX = posX + directionX;
			posY = posX + directionY;
			
			probePicture.pullToFront();
			if (counterCirc == 5) {
				EZ.addCircle(probePicture.getWorldXCenter(), probePicture.getWorldYCenter(), probePicture.getWorldWidth(), probePicture.getWorldHeight(), new Color(224, 224, 224, 10), true).pushToBack();
				counterCirc = 0;
			}
			
			probePicture.translateTo(posX, posY); // Set the position of the probe.
			
			for (int i = 0; i < diamondBlock.length; i++) {
				if (diamondBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter())) {
					diamondSound.play();
					diamondBlock[i].translateTo(0, 0);
					diamondRemainder--;
					System.out.println(diamondRemainder + " Diamonds Remaining.");
				}
			}
			

			for (int i = 0; i < wallBlock.length; i++ ) {
				// diagonal collisions
				if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+1, probePicture.getWorldYCenter()) && wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-1)) {
					directionY = -directionY; // quadrant 1
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-1) && wallBlock[i].isPointInElement(probePicture.getWorldXCenter()-1, probePicture.getWorldYCenter())) {
					directionY = -directionY; // quadrant 2
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()-1, probePicture.getWorldYCenter()) && wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+1)) {
					directionY = -directionY; // quadrant 3
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+1) && wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+1, probePicture.getWorldYCenter())) {
					directionY = -directionY; //quadrant 4
					directionX = -directionX;
					wallSound.play();
				}
				
				// top, bottom, left, right
				else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+1, probePicture.getWorldYCenter()) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter()-1, probePicture.getWorldYCenter())) {
					directionX = -directionX;
					wallSound.play();
				} else if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()+1) || wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-1)) {
					directionY = -directionY;
					wallSound.play();
				}
				
				
				


			
			}
			EZ.refreshScreen();
			
		}
		
		
		applauseSound.play();
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


