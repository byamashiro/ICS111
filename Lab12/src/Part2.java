import java.util.Scanner;
import java.io.*;

public class Part2 {

	public static void main(String[] args) throws java.io.IOException{
		//Open a file called input.txt and give the file to the SCANNER object to read text from the file
		// FileReader fr = new FileReader("input.txt");
		// Scanner scanner = new Scanner(fr);
		Scanner scanner = new Scanner( new FileReader("input.txt") ); // combination of 2 prior lines of code
		
		// Create a file writer object 'fw' using the filename output2.txt
		FileWriter fw = new FileWriter("output2.txt");
		
		int i = 0;
		
		//using scanner.hasNext(), read all the text from input.txt
		while(scanner.hasNext()) {
			//create a variable that stores a word from the text file			
			String word = scanner.next();
			// System.out.println(word);

			
			//if i%3==0, write that word to the file output1.txt
			if (i%3 == 0) {
				fw.write(word);
				if (scanner.hasNext() == true) {
					fw.write(" ");
				}
			}
			
			//increment i
			i++;
		}
		
		//close input.txt
		scanner.close();
		
		//close output1.txt
		fw.close();
		

	}

}
