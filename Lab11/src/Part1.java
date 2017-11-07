import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part1 {
	static final String FILE_NAME = "data.txt";

	public static void main(String[] args) throws FileNotFoundException {
		// initialize variables and the file reader
		float average = 0;
		int[] dollar = new int[10];
		FileReader FileRead = new FileReader(FILE_NAME);

		// initialize the scanner and load the first int as the total
		Scanner scanner = new Scanner(FileRead);
		int total = scanner.nextInt();

		// make a variable
		int i;

		// push variables into the array
		for(i = 0; i < total; i++) {
			dollar[i] = scanner.nextInt();
		}

		scanner.close();

		// sum the elements in the array
		for(i = 0; i < total; i++) {
			average += dollar[i];
		}

		// find the average
		average = average/total;
		System.out.println(average);

	}
}
