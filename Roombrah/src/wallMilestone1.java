import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Collections;

public class wallMilestone1 {
	static int counter = 0; // a global counter for amount of wall blocks, used in milestone 2
	static int[] countElements = new int[2]; // initialize counter array for walls and dirt patches
	
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
						break;
					default:
						break; // if not either a wall or dirt, then just continue on
				}
			} 
		}
		fileScanner.close();
		return new int[] {countElements[0], countElements[1]}; // return the array elements after counting through the entire map
	}
	
	public static void main(String[] args) throws java.io.IOException {
		int countBlocks[] = countBlock(); // use the function to load the array into the main function
		int countWall = countBlocks[0]; // from the array, assign the total number of wall blocks into a variable in the main
		int countDiamond = countBlocks[1];
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt")); // this scanner is used for the main function

		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();

		EZ.initialize(width*32,height*32); // initialize the dimensions of the EZ canvas using the scanned width and height
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		EZImage[] wallBlock = new EZImage[countWall]; // initialize an array for each wall element
		
		for(int row = 0; row < height; row++){
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			
			for (int column = 0; column < inputText.length(); column++){ // for every character
				char ch = inputText.charAt(column); // set a variable for iteration of the loop for an element
		
				switch(ch){
					case 'W': // if the element is a 'W' element... 
						wallBlock[counter] = EZ.addImage("wall.png",column*32+16,row*32+16); // ...assign the element in the wall block array as an EZImage
						counter++; // add 1 to the global counter for total wall blocks
						break; // break statement to start for loop on next element
					case 'D':
						EZ.addImage("diamond.png",column*32,row*32);
						break;
					default:
						break;	
				}
			} 
		}
		fileScanner.close();
		// Print number of wall blocks and diamond blocks (diamond and dirt are used for the same element)
		System.out.println("Total number of wall blocks: " + countWall);
		System.out.println("Total number of diamond blocks: " + countDiamond);
		
		System.out.println("Dimensions: " + width + " x " + height + " Total Blocks: " + (width*height));
	}
}



// =========== Deprecated code kept for reference purposes
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