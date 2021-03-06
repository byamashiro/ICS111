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
public class roombrahRemasteredWithAI_INCOMPLETE {
	
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
		
		// System.out.println(probePicture.getWorldWidth());
		// int countWall = countWallBlock();
		
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
						nullBlock[counterNull] = EZ.addRectangle(column*32+16, row*32+16, 32, 32, Color.gray, true);
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
		int laserX = 17; // posX+17;
		int laserY = 0;
		
		int laserCount = 0;
		int laserFinal = 0;
		int deg = 0;

		int countDiamonds = 0;
		// Set<Integer> setX = new HashSet<Integer>();
		// Set<Integer> setY = new HashSet<Integer>();
		Set<EZImage> setBlock = new HashSet<EZImage>();
		EZImage dButton = EZ.addImage("dblockRe.png", width*32-16,height*32-16);
		int clickX = 0;
		int clickY = 0;
		
		

			
		while(diamondRemainder > 0) { // AI
			
			posX = posX + directionX;
			posY = posY + directionY;
			
			probePicture.pullToFront();
			if (counterCirc == 5) {
				EZ.addCircle(probePicture.getWorldXCenter(), probePicture.getWorldYCenter(), probePicture.getWorldWidth(), probePicture.getWorldHeight(), new Color(224, 224, 224, 10), true).pushToBack();
				counterCirc = 0;
			}
			
			
			// probePicture.translateBy(directionX, directionY);
			probePicture.translateTo(posX, posY); // Set the position of the probe.
			
			
			for (int i = 0; i < diamondBlock.length; i++) {
				if (diamondBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter())) {
					diamondSound.play();
					diamondBlock[i].translateTo(550, 550);
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
			
			
			int scanBreak = 0;
			clickX = EZInteraction.getXMouse(); // Get the mouseʻs X and Y position
			clickY = EZInteraction.getYMouse();
			
			if (EZInteraction.wasMouseLeftButtonReleased()) {
				if (dButton.isPointInElement(clickX, clickY)) { // detect when the mouse is clicked in the water can image   
					while (scanBreak == 0) {
						// counterCirc++;
						System.out.println("I was pressed");
						
						posX = posX + 0; // directionX;
						posY = posY + 0; // directionY;
						
						probePicture.pullToFront();
						if (counterCirc == 5) {
							EZ.addCircle(probePicture.getWorldXCenter(), probePicture.getWorldYCenter(), probePicture.getWorldWidth(), probePicture.getWorldHeight(), new Color(224, 224, 224, 10), true).pushToBack();
							counterCirc = 0;
						}
						
						probePicture.translateTo(posX, posY); // Set the position of the probe.
						
						double rad = Math.toRadians(deg);
						
						EZLine laser = EZ.addLine(probePicture.getWorldXCenter(), probePicture.getWorldYCenter(), (int) (probePicture.getWorldXCenter() + (laserX*Math.cos(rad))),  (int) (probePicture.getWorldYCenter() + (laserX*Math.sin(rad))), Color.red, 5);
			
						/*// only null blocks
						for (int i=0; i<nullBlock.length;i++) {
							if (nullBlock[i].isPointInElement(laser.getX2(), laser.getY2())) {
								// laser.setPoint2(laser.getX2()+17, laser.getY2());
								laserX += 17;
								nullBlock[i].setColor(Color.black);
								laserCount++;
								// laserFinal = laserCount-1;
							} 
						}
						*/
						for (int i=0; i<diamondnullBlock.length;i++) {
							if (diamondnullBlock[i].isPointInElement(laser.getX2(), laser.getY2())) {
								// laser.setPoint2(laser.getX2()+17, laser.getY2());
								laserX += 17;
								diamondnullBlock[i].setColor(Color.red);
								// laserCount++;
								// laserFinal = laserCount-1;
								laser.hide();
								for (int j=0;j<diamondBlock.length;j++) {
									if (  (diamondBlock[j].getWorldXCenter() == diamondnullBlock[i].getWorldXCenter()) && (diamondBlock[j].getWorldYCenter() == diamondnullBlock[i].getWorldYCenter())  ) {
										// setX.add(diamondBlock[j].getWorldXCenter());
										// setY.add(diamondBlock[j].getWorldYCenter());
										setBlock.add(diamondBlock[j]);
			
										countDiamonds++;
									}
								}
			
							} 
						}
						// laserCount++;
						for (int i=0; i<wallBlock.length;i++) {
							if (wallBlock[i].isPointInElement(laser.getX2(), laser.getY2())) {
								deg += 5;
								laserX=17;
								// System.out.println("Changed Degree: " + deg);
								laserCount = 0;
								laser.hide();
							}
						} // need to put export statement here
						
						
						if (deg == 360) {
							
							System.out.println("Detected Diamonds: " + countDiamonds);
							System.out.println("Corrected Diamond Length: " + setBlock.size());
							deg = 0;
							EZImage[] arrBlock = setBlock.toArray(new EZImage[setBlock.size()]);
							// EZImage[] arrBlock = new EZImage[arrBlock_unsorted.length];
				
							// for (int k=0; k<arrBlock.length;k++) {
							while (arrBlock.length > 0) {
								int distHolder = 0;
								int distIndex = 0;
								int distance = 0;
								
								for (int l=0; l<arrBlock.length; l++) {
									System.out.println(arrBlock[l]);
								}
								
								// distance formula d = sqrt( (x-pointx)^2 + (y-pointy)^2 )
								for (int i=0; i<arrBlock.length; i++) {
									System.out.println("Element Dimensions [" + i + "]: (" + arrBlock[i].getWorldXCenter() + ", " + arrBlock[i].getWorldYCenter() + ")");
									distance = (int) Math.sqrt(  Math.pow(( probePicture.getWorldXCenter() - arrBlock[i].getWorldXCenter() ), 2)  + Math.pow(( probePicture.getWorldYCenter() - arrBlock[i].getWorldYCenter() ), 2)  );
									if (distHolder == 0) {
										distHolder = distance;
									} else if (distance < distHolder) {
										distHolder = distance;
										distIndex = i;
									}
									System.out.println("Distance to element [" + i +"] is: " + distance );
								}
								
								System.out.println("The closest distance is the element index: " + distIndex + "    Distance: " + distHolder);
								System.out.println("Current position of Roomba: (" + probePicture.getWorldXCenter() + ", " + probePicture.getWorldYCenter() + ")");
								
								float diffX = arrBlock[distIndex].getWorldXCenter() - probePicture.getWorldXCenter();
								float diffY = arrBlock[distIndex].getWorldYCenter() - probePicture.getWorldYCenter();
								System.out.println("diff x: " +diffX + "  diff y: " + diffY);
				
								float diffPosX = 0f;
								float diffPosY = 0f;
								
								if (Math.abs(diffY) > Math.abs(diffX)) { // making slope for the roomba moving to blocks, but takes the difference of the x1 x2, and y1 y2 points, and also there must be an iteration of 1 per step, therefore the idea was to normalize off of the large absolute value
									diffPosX = diffX / Math.abs(diffY);
									diffPosY = diffY / Math.abs(diffY);
								} else if (Math.abs(diffX) > Math.abs(diffY)) {
									diffPosX = diffX / Math.abs(diffX);
									diffPosY = diffY / Math.abs(diffX);
								}
								System.out.println("index: " + distIndex + "  diffpos x: " + diffPosX + "  diffpos y: " + diffPosY);
				
								
								while (arrBlock[distIndex].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()) == false) { // diamondBlock[4]
									for (int i = 0; i < diamondBlock.length; i++) {
										if (diamondBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter())) {
											diamondSound.play();
											diamondBlock[i].translateTo(550, 550);
											diamondRemainder--;
											System.out.println(diamondRemainder + " Diamonds Remaining.");
										}
									}
									
									if (scanBreak != 1) {
										for (int i=0; i<wallBlock.length; i++) {
											if (probePicture.isPointInElement(wallBlock[i].getWorldXCenter(), wallBlock[i].getWorldYCenter())) {
												System.out.println("I AM HITTING A WALL!");
												// arrBlock = ArrayUtils.remove(arrBlock, distIndex);
												scanBreak = 1;
												break;
											}
			
										}
									}
			
									
									if (scanBreak != 1) {
										probePicture.translateBy(diffPosX, diffPosY);
									}
									//probePicture.translateBy(diffPosX, diffPosY);
									// System.out.println("Ending triggered");
									EZ.refreshScreen();
								}
								// arrBlock[distIndex] = ;
								arrBlock = ArrayUtils.remove(arrBlock, distIndex);
								// arrBlock[distIndex] =
							}
			
							// break;
							posX = probePicture.getWorldXCenter();
							posY = probePicture.getWorldYCenter();

							break;
						}
					}
				}
			}
			
			/*// slow version of scanning
			if (laserCount == 50) {
				laser.hide();
				deg += 10;
				laserX=17;
				System.out.println("Changed Degree: " + deg);
				laserCount = 0;
			}
			*/
			
			// System.out.println("Count: " + laserCount + "   " + "Laser Final: " + laserFinal);
			
			//if (laserCount == )			
			// laserX = 17;
			// System.out.println("Degree: " + deg);
			
			
			
			
			
			
			/*
			for (int j=0;j<360;j++) {
				// EZLine laser = EZ.addLine(posX, posY, laserX, laserY, Color.red, 5);
				double rad = Math.toRadians(j);
				int laserX = 17;

				
				for (int i=0; i<nullBlock.length;i++) {
					EZLine laser = EZ.addLine(posX, posY, (int) (probePicture.getWorldXCenter() + (laserX*Math.cos(rad))),  (int) (probePicture.getWorldYCenter() + (laserX*Math.sin(rad))), Color.red, 5);

					if (nullBlock[i].isPointInElement(laser.getX2(), laser.getY2())) {
						laserX += 17;
						nullBlock[i].setColor(Color.black);
					}
					EZ.refreshScreen();
				}
			}
			*/
			
			/*
			for (int i = 0; i < 360 ; i++) {
				double rad = Math.toRadians(i);
				// System.out.println("radians: " + rad);
				probePointsX[i] = (int) (probePicture.getWorldXCenter() + (16*Math.cos(rad))); // tried lower values for r, originally 17 for predictive hits
				probePointsY[i] = (int) (probePicture.getWorldYCenter() + (16*Math.sin(rad)));
				// System.out.println("probe X: " + probePointsX[i] + " probe Y: " + probePointsY[i] );
			}
			*/
			// if (wallBlock[i].isPointInElement(probePicture.getWorldXCenter()+1, probePicture.getWorldYCenter()) && wallBlock[i].isPointInElement(probePicture.getWorldXCenter(), probePicture.getWorldYCenter()-1)) {

			
			

			
			/*
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
			*/
			EZ.refreshScreen();
		}
		
		
		
		/*
		while(diamondRemainder > 0){
			counterCirc++;

			posX = posX + directionX;
			posY = posY + directionY;
			
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
		*/
		
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


