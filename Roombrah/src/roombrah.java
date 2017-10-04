import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Collections;


public class roombrah {
	static int counter = 0;
	
	public static void main(String[] args) throws java.io.IOException {
		
		
		
		int posX = 100;		//0	// Stores the x position of the probe
		int posY = 100;			// Stores the y position of the probe	
		int directionX = 1;		// Stores the x direction of the probe
		int directionY = 1;		// Stores the y direction of the probe
		int rotationAngle = 0;	// Stores the rotation angle of the probe
		int saberX = 700/2;		// Stores X Position of the light saber 

		int bounces = 0;		// Stores the number of times the probe has bounced off the lightsaber
		
		
		
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));

		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();

		EZ.initialize(width*32,height*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		EZImage probePicture = EZ.addImage("probe.png", 0,0);
		probePicture.scaleBy(0.3);
		System.out.println(probePicture.getWorldWidth());
		
		int wallNo = 300;
		
		int[] wallXLeft = new int[wallNo];
		int[] wallYLeft = new int[wallNo];
		
		int[] wallXRight = new int[wallNo];
		int[] wallYRight = new int[wallNo];
		
		int[] wallXTop = new int[wallNo];
		int[] wallYTop = new int[wallNo];
		
		int[] wallXBottom = new int[wallNo];
		int[] wallYBottom = new int[wallNo];
		
		// EZImage[] wallArray = new EZImage[200];

		int[] blockX = new int[wallNo];
		int[] blockY = new int[wallNo];
		
		EZImage[] wallBlock = new EZImage[wallNo];
		
		for(int row = 0; row < height; row++){
			
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			
			// int counter = 0;
			for (int column = 0; column < inputText.length(); column++){
				
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'W':
						// wallArray[counter] = EZ.addImage("dirt.png",column*32,row*32);
						// EZImage wallPlacement = EZ.addImage("dirt.png",column*32,row*32);
						
						
						wallBlock[counter] = EZ.addImage("dirt.png",column*32,row*32);
						System.out.println("wall center: " + wallBlock[counter].getWorldXCenter() + ", " + wallBlock[counter].getWorldYCenter());
						
						counter++;
						
						/*
						for (int j=0; j<=32; j++) { // This code works for when the wall is the modifier
							wallXLeft[counter] = wallPlacement.getXCenter() - 16;
							wallYLeft[counter] = wallPlacement.getYCenter() + j - 16;

							wallXRight[counter] = wallPlacement.getXCenter() + 16;
							wallYRight[counter] = wallPlacement.getYCenter() + j - 16;
							
							wallXTop[counter] = wallPlacement.getXCenter() + j - 16 ;
							wallYTop[counter] = wallPlacement.getYCenter() + 16;

							wallXBottom[counter] = wallPlacement.getXCenter() + j - 16 ;
							wallYBottom[counter] = wallPlacement.getYCenter() - 16;
							
							counter++;
						}
						*/

						// System.out.println("width: " + wallPlacement.getWidth());
						// System.out.println("height: " + wallPlacement.getHeight());
						
						
						break;	
						
					case 'D':
						EZ.addImage("grass.png",column*32,row*32);
						
						break;
					/*
					case 'L':
						EZ.addImage("lava.png",column*32,row*32);
						break;
					*/ 
					default:
						// Do nothing
						break;
							
				}
			} 
		}
		

		
		while(true){
			posX = posX + directionX;
			posY = posY + directionY;
			
			probePicture.translateTo(posX, posY); // Set the position of the probe.

			
			int posXLeft = probePicture.getWorldXCenter() - 8;
			int posYLeft = probePicture.getWorldYCenter();
			System.out.println("left: " + posXLeft + " " + posYLeft);

			int posXRight = probePicture.getWorldXCenter() + 8;
			int posYRight = probePicture.getWorldYCenter();
			System.out.println("right: " + posXRight + " " + posYRight);

			
			int posXTop = probePicture.getWorldXCenter();
			int posYTop = probePicture.getWorldYCenter() + 8;
			System.out.println("top: " + posXTop + " " + posYTop);


			int posXBottom = probePicture.getWorldXCenter();
			int posYBottom = probePicture.getWorldYCenter() - 8;
			System.out.println("bottom: " + posXBottom + " " + posYBottom);


			// probePicture.rotateTo(rotationAngle); // Set the rotation angle of the probe.
			// System.out.println(posX + ", " + posY + ", " + "outside");
			// rotationAngle+=directionX;

			/*
			if (posX > 700 ) {
				directionX = -directionX;
			}
			if (posX < 0) {
				directionX = -directionX;
			}
			*/
			System.out.println("array length: " + wallBlock.length);

			System.out.println(posX + ", " + posY);
			
			for (int i = 0; i < wallNo; i++ ) {
				// System.out.println(wallBlock[i]);
				if (wallBlock[i].isPointInElement(posXLeft, posYLeft) || wallBlock[i].isPointInElement(posXRight, posYRight)) {
					directionX = -directionX;
				} else if (wallBlock[i].isPointInElement(posXTop, posYTop) || wallBlock[i].isPointInElement(posXBottom, posYBottom)) {
					directionY = -directionY;
				}
				
				
				/*
				if ( probePicture.isPointInElement( wallXLeft[i], wallYLeft[i]  ) || probePicture.isPointInElement( wallXRight[i], wallYRight[i] ) ) { // 	if (probePicture.isPointInElement( wallX[i], wallY[i]  ) ) {
					directionX = -directionX;
					break;
				} else if ( probePicture.isPointInElement( wallXTop[i], wallYTop[i]  ) || probePicture.isPointInElement( wallXBottom[i], wallYBottom[i] ) ) {
					directionY = -directionY;
					break;
				}
				*/
			}
			
			/*
			for ( int j = 0; j < 200; j++ ) {
				System.out.println(wallX[j] + ", " + wallY[j]);
				if ((posX == wallX[j]) && (posY == wallY[j])) {
					System.out.println(wallX[j] + ", " + wallY[j] + ", " + "I AM BEING TRIGGERED!");
					directionX = -directionX ;
					directionY = -directionY;
				}
			}
			*/

			
//			if ((posX > 700) || (posX < 0)) {
//				directionX = -directionX;
//			}
			/*
			if (posY > 600 ) {		// if the ball reaches all the way to the bottom reset it to the top
				posY=0;
			}
			if (posY < 0) {
				directionY = -directionY;
			}
			*/
			
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
			
			/*
			int halfSaberWidth = saberPicture.getWidth()/2;
			
			saberPicture.translateTo(saberX,480);
			
			if ((posX < saberX+halfSaberWidth) && (posX > saberX-halfSaberWidth) && (posY > 460) && (posY < 480)){

				directionY = -directionY;
				clashSound.play();
				bounces++;
				if (bounces == 3) {
					impressiveSound.play();
					bounces = 0;
				}
			}
			*/
			
			EZ.refreshScreen();
		}
	}
}