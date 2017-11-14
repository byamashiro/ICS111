import java.io.FileWriter;		// Import the java input / output library
public class Part1 {

	public static void main(String[] args) throws java.io.IOException {
		// Create a file writer object using the filename "output1.txt"
		FileWriter fw = new FileWriter("output1.txt");
		
		String str = "startrek";
		
		//iterate through the length of the string "str"
		for (int i=0; i < str.length();i++) {					
			//declare a character 'ch' and assign it the character of str at index i (use str.charAt(i))
			// System.out.println(str.charAt(i));
			char ch = str.charAt(i);
					
			//use switch statement as per the requirement of the output
			switch(ch) {
				case 's':
					fw.write('S');
					break;
				case 't':
					fw.write('T');
					break;
				case 'k':
					fw.write('K');
					break;
				case 'r':
					fw.write('r');
					break;
				default:
					fw.write('_'); //Hint: use "_" for default case	
					break;
			}	
		}
		fw.close(); //Do not forget to close the file
	}
}
