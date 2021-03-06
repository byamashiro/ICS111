import java.util.Scanner;

public class Coins {
	
	public static void main(String[] args) {

		// scanner provided for user input
		Scanner scan = new Scanner(System.in);
		
		// create variable to hold amount of change
		int change;
		
		// prompt user to enter an amount of change
		System.out.println("Please enter an amount of change: ");
		
		// use scan.nextInt() to get amount of change from user and save it to change variable
		change = scan.nextInt();
		System.out.println(change + " cents is: ");
		
		// call printCoins function to print amount of coins from the amount of change
		
		printCoins(change); // invokes the function "printCoins();"  for the input integer of change
	}

	/* 
	TODO:
	Write a function called 'printCoins' that takes in an amount of change 
	and then prints out the amount of quarters, dimes, and pennies needed 
	to provide the necessary change.
	
	Ex: 67 cents is 2 quarters, 1 dime, and 7 pennies  
	*/
	static void printCoins(int change) { // outputs the number of quarters, dimes, and pennies
		int coins = change;
		int quarters = coins/25; // divide the quantity by 25 to obtain the number of full quarters, and truncates the rest
		coins -= quarters*25; // subtracts the value of full number quarters from the total quantity and reassigns the new value to coins
		int dimes = coins/10;
		coins -= dimes*10;
		int pennies = coins/1;
		coins -= pennies*1;
		
		System.out.println(quarters + " quarters"); // prints the amount of full number quarters
		System.out.println(dimes + " dimes");
		System.out.println(pennies + " pennies");
	}
	
	
	
}
