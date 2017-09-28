package lab_3;

public class Parb {

	public static void main(String[] args) {
		int a = 44; // declare an integer called a and initialize it to 44
		int b = 7; // declare an integer called b and initialize it to 7
		int q = 0; // declare an integer called q and initialize it to 0
		do {// start a “do” loop
			a = a - b; // subtract b from a and put that value in a
			if (a >= 0) { // check if a is bigger or equal to 0
				q++; // if it is, increment q
			}
			
		} while (a >= b); // the loop runs while a is bigger or equal to b
		
		
		
		System.out.println("The value of q is: " + q); // print out the value of q

	}

}
