//import java.awt.Color;
import java.util.Scanner;

public class Month {

	public static void main(String[] args) {
		int month;
		String season;
		Scanner month_in = new Scanner(System.in);
		System.out.println("Enter the month number: ");
		month = month_in.nextInt();
		
		
		
		if (month == 12 || month == 1 || month == 2) {
			season = "Spring";
		}
		else if (month == 3 || month == 4 || month == 5) {
			season = "Summer";
		}
		else if (month == 6 || month == 7 || month == 8) {
			season = "Autumn";
		}
		else if (month == 9 || month == 10 || month == 11) {
			season = "Winter";
		}
		else {
			season = "Bogus Month";
		}
		
		System.out.println("The month you entered is in the " + season + ".");
		
	}

}
