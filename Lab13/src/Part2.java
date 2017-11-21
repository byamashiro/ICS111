
public class Part2 {
	// a function that prints out the contents of the entire array
	public static void print2DArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//Create a 2D array called array of size of size 9*23		
		//Note: Here we assume that first index represents the rows
		//and the second index represents the columns
		String[][] array = new String[9][23];


		//initially filling all the cells of the array with blank spaces (" ")
		//we use a nested for loop to do this
		for(int i=0; i<9; i++) {
			for(int j = 0; j< 23; j++) {
				array[i][j] = " ";
			}
		}

		// Now, we use a nested for loop to fill in the I
		// For this, we have to iterate over all rows and columns 0 through 6
		for(int i=0; i<9; i++) {
			for(int j =0; j< 7; j++) {
				//If we see the desired output, we want "x" for i=0, i=8 and j=3
				//So use if(i==0 || i == 8 || j == 3) to overwrite the spaces in the array with "x" for these rows/columns
				//i.e set array[i][j] to "x"
				if (i==0 || i==8 || j ==3) {
					array[i][j] = "x";
				} else {
					array[i][j] = " "; //for the other values of i and j, keep blank spaces as they are
				}
			}
		}

		// Now, write a nested for loop for filling C
		// the outer loop should be same as before (why?)
		//but j should start at 8 and end at 14. Why?: (count the column numbers for the starting and ending of C)
		for (int i=0; i<9; i++) {
			for (int j=8; j<15; j++) {
				if (i==0||i==8||j==8) {
					array[i][j] = "x"; //think for what values of i and j should we fill array[i][j] with "x"?
				} else {
					array[i][j] = " "; //for the other values of i and j, keep blank spaces as they are
				}
			}
		}

		
		// Likewise, write another nested for loop for filling S
		for (int i=0; i<9; i++) {
			for (int j=16; j<23; j++) {
				if (i==0||i==8||i==4||(j==16 && i<4)||(j==22 && i>4)) {
					array[i][j] = "x"; //think for what values of i and j should we fill array[i][j] with "x"?
				} else {
					array[i][j] = " "; //for the other values of i and j, keep blank spaces as they are
				}
			}
		}

		// call the print2DArray function passing array as parameter
		print2DArray(array);
		
	}
}
