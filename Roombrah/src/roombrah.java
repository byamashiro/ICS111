import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Collections;


public class roombrah {
	static int counter = 0;
	
	static int countWallBlock() throws java.io.IOException {
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));
		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();
		
		
		int countWall = 0;
		for(int row = 0; row < height; row++){ // get the count of wall blocks
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			for (int column = 0; column < inputText.length(); column++){
				char ch = inputText.charAt(column);
				switch(ch){
					case 'W':
						countWall++;
						break;	
					case 'D':						
						break;
					default:
						break;		
				}
			} 
		}
	return countWall;
	}
	
	public static void main(String[] args) throws java.io.IOException {
		int posX = 200;		//0	// Stores the x position of the probe
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
		// System.out.println(probePicture.getWorldWidth());
		
		
		int countWall = countWallBlock();
		
		EZImage[] wallBlock = new EZImage[countWall];
		// System.out.println("Amount of wall blocks: " + countWall);
		
		for(int row = 0; row < height; row++){
			inputText = fileScanner.nextLine();
			// System.out.println(inputText);
			
			for (int column = 0; column < inputText.length(); column++){
				
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'W':
						wallBlock[counter] = EZ.addImage("dirt.png",column*32,row*32);
						// System.out.println("wall center: " + wallBlock[counter].getWorldXCenter() + ", " + wallBlock[counter].getWorldYCenter());
						counter++;
						break;	
						
					case 'D':
						EZ.addImage("grass.png",column*32,row*32);
						break;

					default:
						break;
							
				}
			} 
		}
		

		
		while(true){

			posX = posX + directionX;
			posY = posY + directionY;
			
			probePicture.translateTo(posX, posY); // Set the position of the probe.
			
			int[] probePointsX = new int[360];
			int[] probePointsY = new int[360];
			
			for (int i = 0; i < 360 ; i++) {
				double rad = Math.toRadians(i);
				// System.out.println("radians: " + rad);
				probePointsX[i] = (int) (probePicture.getWorldXCenter() + (16*Math.cos(rad))); // tried lower values for r, originally 17 for predictive hits
				probePointsY[i] = (int) (probePicture.getWorldYCenter() + (16*Math.sin(rad)));
				// System.out.println("probe X: " + probePointsX[i] + " probe Y: " + probePointsY[i] );
			}
			

			for (int i = 0; i < wallBlock.length; i++ ) {
				/*
				for (int j=0; j<360; j++) {
					if ( (j==0) || (j==30)  || (j==150) || (j==180) || (j==210) || (j==330) ) { // change to possibly 3 points per quadrant instead
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
			
			}
			EZ.refreshScreen();

		}
	}
}