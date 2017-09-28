package lab_2;
import java.awt.Color;



public class lab2 {

	public static void main(String[] args) {
		
		//==============PART A

		// declare an int called average
		int average;
		
		// declare an int variable named g1 and assign 78 to it
		int g1 = 78;

		// declare an int variable named g2 and assign g1 plus 7 to it
		int g2 = g1 + 7;

		// declare an int variable named g3 and assign g2 minus 2 to it
		int g3 = g2 - 2;

		// add g1, g2, and g3 and assign that value to average
		average = g1 + g2 + g3;

		// assign average divided by 3 to average
		average /= 3;
		
		// print out on one line “The average of “ followed by the values of g1, g2, and g3 separated by “,”
		System.out.println("The average of " + g1 + ", " + g2 + ", " + g3);

		// print out on one line “is ”, followed by average
		System.out.println("is " + g1);
		
		// check if the value of average is more than 75
		if (average > 75) {
			//if it is, print "Good job"
			System.out.println("Good job");
			
			
		// ======= Part B
		int val = 9 ; // 9, 8, 13
		
		if  ( val % 2 == 0) {
			System.out.println(val + " is divisible by 2");
		} else {
			if ( val % 3 == 0 ) { // val % 3 works here as well
				System.out.println(val + " is divisible by 3");
			} else {
				System.out.println("your number is " + val);
			}
		}
		
		// ========= Part C
		int sheep_count = 0;
		int number_iter_x = 0;
		int number_iter_y = 0;
		EZ.initialize(200, 200); // with EZ

		
		while (sheep_count < 10) {
			System.out.println(sheep_count);
			
			number_iter_x += 15;
			number_iter_y += 15;
			
			EZText sheep = EZ.addText(number_iter_x, number_iter_y, "SHEEP", Color.RED);
			
			sheep_count += 1;
		}
		
				
		
		
			
		/* 
		int[] val = {9, 8, 13};
		
		for (int i = 0; i < val.length; i++) {
			if ((val[i] / 2)  % 2 == 0) {
				System.out.println(val + " is divisible by 2");
			} else if
		}
		*/
			
			
			
		
		}
		
		
		
		
		
		

	}

}
