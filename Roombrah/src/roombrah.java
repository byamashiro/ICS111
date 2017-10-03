import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


public class roombrah {
	static int counter = 0;
	
	public static void main(String[] args) throws java.io.IOException {
		
		
		
		int posX = 100;		//0	// Stores the x position of the probe
		int posY = 200;			// Stores the y position of the probe	
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
		
		int[] wallXLeft = new int[1000];
		int[] wallYLeft = new int[1000];
		
		int[] wallXRight = new int[1000];
		int[] wallYRight = new int[1000];
		
		int[] wallXTop = new int[1000];
		int[] wallYTop = new int[1000];
		
		int[] wallXBottom = new int[1000];
		int[] wallYBottom = new int[1000];
		
		
		for(int row = 0; row < height; row++){
			
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			
			// int counter = 0;
			for (int column = 0; column < inputText.length(); column++){
				
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'W':
						EZImage wallPlacement = EZ.addImage("dirt.png",column*32,row*32);
						wallXLeft[counter] = wallPlacement.getXCenter() - 16;
						wallYLeft[counter] = wallPlacement.getYCenter();

						wallXRight[counter] = wallPlacement.getXCenter() + 16;
						wallYRight[counter] = wallPlacement.getYCenter();
						
						wallXTop[counter] = wallPlacement.getXCenter();
						wallYTop[counter] = wallPlacement.getYCenter() + 16;

						wallXBottom[counter] = wallPlacement.getXCenter();
						wallYBottom[counter] = wallPlacement.getYCenter() - 16;

						
						// System.out.println("width: " + wallPlacement.getWidth());
						// System.out.println("height: " + wallPlacement.getHeight());

						counter++;
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
		
		/*
		for (int i=0; i<counter; i++) {
			System.out.println(wallX[i] + ", " + wallY[i]);
		}
		*/
		

		
		while(true){
			
			probePicture.translateTo(posX, posY); // Set the position of the probe.

			// probePicture.rotateTo(rotationAngle); // Set the rotation angle of the probe.
								
			posX = posX+directionX;
			posY = posY+directionY;
			
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
			
			int probe_top = posY + 1;
			int probe_bottom = posY - 1;
			int probe_left = posX - 1;
			int probe_right = posX + 1;
			
			for (int i = 0; i < 200; i++ ) {

				
				if (probePicture.isPointInElement( wallXLeft[i], wallYLeft[i]  ) || probePicture.isPointInElement( wallXRight[i], wallYRight[i]  )) { // 	if (probePicture.isPointInElement( wallX[i], wallY[i]  ) ) {
					// System.out.println("I AM BEING TRIGGERED");
					directionX = -directionX;
					
					// if (wallX[0] )
					
				} else if (probePicture.isPointInElement( wallXTop[i], wallYTop[i]  ) || probePicture.isPointInElement( wallXBottom[i], wallYBottom[i]  )) {
					directionY = -directionY;

				}
				
				
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
			
			if (posY > 600 ) {		// if the ball reaches all the way to the bottom reset it to the top
				posY=0;
			}
			if (posY < 0) {
				directionY = -directionY;
			}
			
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