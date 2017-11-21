import java.util.Arrays;

public class Array2D {
	static int ROWS = 7;
	static int COLUMNS = 7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] array = new String[ROWS][COLUMNS];
		for (int row = 0; row<ROWS; row++) {
			for (int col=0; col<COLUMNS; col++) {
				array[row][col] = "hello";
			}
		}
		System.out.println(Arrays.deepToString(array));
	}
	

}
