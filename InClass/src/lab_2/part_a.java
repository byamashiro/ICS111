package lab_2;
import java.awt.Color;


public class part_a {

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
		}


}}
