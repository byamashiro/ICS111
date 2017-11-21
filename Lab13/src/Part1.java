import java.util.*;
public class Part1 {
	
	public static void main(String[] args) {
		// Declare and initialize an ArrayList of Strings called sharks.
		ArrayList<String> sharks = new ArrayList<String>();
	
		// Use the add(Object o) method to add the following names to the array:
		// "Bull Shark", "Happy Shark", "Sand Tiger Shark", "Tiger Shark", "Totoro Shark"
		sharks.add("Bull Shark");
		sharks.add("Happy Shark");
		sharks.add("Sand Tiger Shark");
		sharks.add("Tiger Shark");
		sharks.add("Totoro Shark");
		
		// Use the set(int index, Object o) method to change "Happy Shark" to "Great White Shark"
		sharks.set(1, "Great White Shark");
		
		// Use the add(int index, Object o) method to insert "Blacktip Reef Shark" into index 0
		sharks.add(0, "Blacktip Reef Shark");
		
		// Use the remove(Object o) OR remove(int index) method to remove "Totoro Shark"
		sharks.remove("Totoro Shark");
		
		// Use a for loop to print out all the shark names in the ArrayList.  
		// You will need to use the size() and get(int index) methods to accomplish this
		for (int i=0; i<sharks.size(); i++) {
			System.out.println(sharks.get(i));
		}
		
	}
}

