import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Collections;

public class wallMilestone1 {
	static int counter = 0;
	static int[] countElements = new int[2];
	
	static int[] countBlock() throws java.io.IOException {
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));
		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();
		int countDiamond = 0;
		int countWall = 0;

		for(int row = 0; row < height; row++){ // get the count of wall blocks
			inputText = fileScanner.nextLine();
			for (int column = 0; column < inputText.length(); column++){
				char ch = inputText.charAt(column);
				switch(ch){
					case 'W':
						countElements[0]++; // countWall++;
						break;	
					case 'D':
						countElements[1]++; // countDiamond++;
						break;
					default:
						break;		
				}
			} 
		// countElements[0] = countWall;
		// countElements[1] = countDiamond;
			
		}
		// return countElements;
		return new int[] {countElements[0], countElements[1]};
	}
	
	public static void main(String[] args) throws java.io.IOException {
		int countBlocks[] = countBlock();
		int countWall = countBlocks[0];
		int countDiamond = countBlocks[1];
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));

		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();

		EZ.initialize(width*32,height*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		// int countWall = countElements[0]; // countWallBlock();
		// int countDiamond = countElements[1]; //countDiamondBlock();
		
		EZImage[] wallBlock = new EZImage[countWall];
		
		for(int row = 0; row < height; row++){
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			
			for (int column = 0; column < inputText.length(); column++){
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'W':
						wallBlock[counter] = EZ.addImage("wall.png",column*32+16,row*32+16);
						counter++;
						break;	
					case 'D':
						EZ.addImage("diamond.png",column*32,row*32);
						break;
					default:
						break;	
				}
			} 
		}
		
		// Print number of wall blocks
		System.out.println("Total number of wall blocks: " + countWall);
		System.out.println("Total number of diamond blocks: " + countDiamond);


	}
}




/*
static int countWallBlock() throws java.io.IOException {
	Scanner fileScanner = new Scanner(new FileReader("level.txt"));
	int width = fileScanner.nextInt();
	int height = fileScanner.nextInt();
	String inputText = fileScanner.nextLine();
	
	int countWall = 0;
	for(int row = 0; row < height; row++){ // get the count of wall blocks
		inputText = fileScanner.nextLine();
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


static int countDiamondBlock() throws java.io.IOException {
	Scanner fileScanner = new Scanner(new FileReader("level.txt"));
	int width = fileScanner.nextInt();
	int height = fileScanner.nextInt();
	String inputText = fileScanner.nextLine();
	
	int countDiamond = 0;

	for(int row = 0; row < height; row++){ // get the count of wall blocks
		inputText = fileScanner.nextLine();
		for (int column = 0; column < inputText.length(); column++){
			char ch = inputText.charAt(column);
			switch(ch){
				case 'W':
					break;	
				case 'D':	
					countDiamond++;
					break;
				default:
					break;		
			}
		} 
	}
return countDiamond;
}
*/