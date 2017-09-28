package Lab4;

import java.io.InputStreamReader;
import java.util.Scanner;


public class Partb {
	
	static Scanner scanner;

	// create a static function to print out all factors of a positive integer
	// the function should accept one parameter, which is the integer being factored
	public static void factorize(int num) {
		int x = num; // have the input assigned to the highest term
		int y = 1; // starting value, this will be incremented to show all factors in the range of y < x+1
		String z = x + ":"; // print out the highest value and have a ":" after it
		while(y < x+1){ // try all numbers between y and x, not including x+1
			if(x % y == 0){ // if the number is a factor, it will return 0 when mod(y), check if x mod y returns 0
				z += " " + y; // print all of the possible factors
			}
			y++; // increase the value of y by 1
		}
		System.out.println(z); // prints the factorized number

	}
	
	
	public static void main(String[] args) {
		
		scanner = new Scanner(new InputStreamReader(System.in));  // initialize a scanner for an input from console
		System.out.print("Enter a number to factorize: "); // console prompt for console input
		int number = scanner.nextInt(); // scan in the number input via the console
		
		factorize(number); // factorize input number using factorize function
			
	}
}

