
public class Part2 {

	public static void main(String[] args) {
		
		int fltSz = 6; // initialize fltSz to be size 6
		float[] numberList; // declare an array of type float called 'numberList'.
		numberList = new float[fltSz];  // initialize numberList to be size 6 (from fltSz)
	

		System.out.println("Inserting Values...");
		
		// NOTE: each individual element of the array can be treated as if it were a variable
		
		// assign the value 5 to the element at index 0 (the first index)
		numberList[0] = 5; 
		
		// assign the value -4 to the element at index 1
		numberList[1] = -4;
		
		// assign the value 3.14 to the element at index 2
		numberList[2] = 3.14f;
		
		// assign the value 1.618 + numberList[0] to the element at index 3
		numberList[3] = 1.618f + numberList[0];
		
		// assign the value numberList[1] + numberList[3] to the the element at the last index
		numberList[5] = numberList[1] + numberList[3];
		
		System.out.println("\nValues:");
		
		// Print all values in the array without using a loop, ie calling System.out.println 6 times with each index.
		System.out.println("Element " + "1" + ", " + numberList[0]); // printing manually
		System.out.println("Element " + "2" + ", " + numberList[1]);
		System.out.println("Element " + "3" + ", " + numberList[2]);
		System.out.println("Element " + "4" + ", " + numberList[3]);
		System.out.println("Element " + "5" + ", " + numberList[4]);
		System.out.println("Element " + "6" + ", " + numberList[5]);


		
		System.out.println("\nWhile loop:");
		
		// use a while loop to print out all of the values
		int j = 0;
		while (j < fltSz) { // while j is less than 6, print values for each element from 0 to 5
			System.out.println("Element " + j + ", " + numberList[j]);
			j++;
		}
		System.out.println("\nFor loop:");

		
		// now, use a for loop to print out all of the values
		for (int i=0; i<fltSz; i++) { // for loop from 0 to less than 6, print each element from 0 to 5
			System.out.println("Element " + i + ", " + numberList[i]);
		}
		
		System.out.println("\nOverwriting...");
		
		// using a for loop, overwrite each value in the array to 2.4f + i, where i is the index in the array
		for (int k=0; k<fltSz; k++) { // assigning new values to the array
			numberList[k] = 2.4f + k;
		}
		
		System.out.println("\nReverse Print:");
		
		// now use a while loop to print out all the values in the array in REVERSE order. 
		// NOTE: you can reuse the same iterator variable as the previous while loop.
		int l = 5;
		// from 5 to 0 print each element and decrement by 1 every iteration
		while (l >= 0) {
			System.out.println("Element " + l + ", " + numberList[l]); 
			l--;
		}
		
	}
	
}
