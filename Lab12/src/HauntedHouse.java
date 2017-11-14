

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class HauntedHouse {

	// a constant for the number of items we will have
	public final static int ITEM_COUNT = 6;
	
	
	// readFile function: 
	// arguments: a name of a file to read
	// returns: an array of Draggable objects created based on data from the file
	public static Draggable [] readFile(String fileName) throws java.io.IOException {
		Scanner s = new Scanner (new FileReader(fileName));

		Draggable [] arr = new Draggable[ITEM_COUNT];
		for (int i =0; i<ITEM_COUNT; i++) {
			String fn = s.next();
			int x = s.nextInt();
			int y = s.nextInt();
			arr[i] = new Draggable(fn, x, y);
		}
		s.close();
		return arr;
	}
	
	
	// saveFile function:
	// arguments: a name of a file to write
	//			  an array of Draggable objects whose data to write in the file
	public static void saveFile(String fileName, Draggable [] arr) throws java.io.IOException {
		//  ADD YOUR CODE HERE
		FileWriter fw = new FileWriter("positions.txt");
		
		for (int i =0; i<ITEM_COUNT; i++) {
			String name = arr[i].getFileName();
			// System.out.println(name);
			fw.write(name + " ");
			
			int newX = arr[i].getX();
			// System.out.println(newX);
			fw.write(newX + " ");
			
			int newY = arr[i].getY();
			// System.out.println(newY);
			fw.write(newY + "\n");
		}
		fw.close();
		// 
	}
	
	
	// Main
	public static void main(String[] args) throws java.io.IOException {
		EZ.initialize(1024, 576);
		
		// Add background
		EZImage bg = EZ.addImage("HouseBG.jpg", 512, 288);
	
		// Create the array of objects by reading from a file
		Draggable [] objects = readFile("positions.txt");
		
		// Main loop
		while (true) {
			// check for interactions on all objects (for dragging)
			for(int i=0; i<ITEM_COUNT; i++) {
				objects[i].interact();
			}
			
			// check for user's clicking 's' to save file
			if (EZInteraction.wasKeyPressed('s')) {
				saveFile("positions.txt", objects);
			}
			
			EZ.refreshScreen();
		}

	}

}
