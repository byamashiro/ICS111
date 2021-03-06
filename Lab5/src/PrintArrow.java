import java.util.Scanner;

public class PrintArrow {
	
	public static void main(String[] args) {
		// get desired arrow length from user. You will need make your own scanner this time.
		Scanner scan = new Scanner(System.in); // scanner initialize for arrow length input
		int arrowLength;
		System.out.println("Please enter desired arrow length: "); // prompt for arrow length
		arrowLength = scan.nextInt();		
		
		printArrow(arrowLength); // invoke printArrow function to generate arrow of length "arrowLength"
	}
	
	/*
	TODO 3:
	Finally write a function called printArrow that calls  
	printArrowRow 5 times for each row of the arrow.
	
	Ex: An arrow with an input length of 7 should have the following output,
		"       #"
		"       ##"
		"##########"
		"       ##"
		"       #"
	*/
	static void printArrow(int length) {
		int i = 1;
		
		while (i <= 5) {
			if (i < 3) {
				printArrowRow(length, i, " "); // arrow head rays (top)
			} else if (i == 3) {
				printArrowRow(length, i, "#"); // make arrow point and stem
			} else if (i == 4) {
				printArrowRow(length, 2, " "); //arrow head rays (bottom)
			} else if (i == 5) {
				printArrowRow(length, 1, " ");
			}
			i++;
		}
	}

	
	
	/*
	TODO 2:
	Write another function called printArrowRow that  
	uses loopString to print a single row of the arrow. 
	
	Ex: The 2nd row down of an arrow of input length 3 should print this  "   ##"
	    The 3nd row down of an arrow of input length 3 should print this  "#####"

	HINT: Parameters may help to determine the number of spaces vs hashtags to print.
	*/
	public static void printArrowRow(int spaces, int hashes, String s) { // print row with a number of spaces, hashes, and a variant string
		String space = loopString(spaces, s); // use loopString to create the spaces on the left and change the character
		String hash = loopString(hashes, "#"); // creates the hashes for the arrow head
		
		System.out.println(space + hash); // concatenates the spaces/stem to the arrow head
	}
	
	
	/*
	TODO 1:
	Write a function called loopString to iteratively concatenate a string together a specified number of times.
	
	Ex: an input string "yo" and an input number of 4 should return the string "yoyoyoyo"
	*/
	public static String loopString(int a, String b) { // input the length and characters
		String s = "";
		int i = 0;
		while (i < a) { // while loop to make a string of i length, and concatenate the characters on characters
			s += b;
			i++;
		}
		return s;
	}
	
}
