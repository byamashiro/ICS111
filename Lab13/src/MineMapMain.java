import java.io.FileWriter;

public class MineMapMain {

	static final int rows = 10;
	static final int cols = 10;

	public static void main(String[] args) throws java.io.IOException {
		EZ.initialize(cols*32, rows*32);

		//Create a 2D array for a Tile object called "map" of size [rows][cols]
		Tile [][] map = new Tile[rows][cols];

		// first we build the initial map
		// we use a nested for loop to set the contents of the array to Tile objects
		// the outer loop should iterate through rows, the inner loop columns
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				//we use j*32+16 and i*32+16 as parameters
				map[i][j] = new Tile(j*32 + 16, i*32 + 16);
			}
		}

		while (true) {
			// check for clicks and if there is a click, change the state of the clicked tile
			//Check if the mouse left button is released
			if (EZInteraction.wasMouseLeftButtonReleased()) {

				// calculate the array indices of the clicked element into the 2d array
				int i = EZInteraction.getYMouse()/32;
				int j = EZInteraction.getXMouse()/32;

				//change the state of the tile using map[i][j].changeState() function
				map[i][j].changeState();

			}

			//if the user presses the character 's', get characters for each tile state and save it into a file
			// Check if we want to save file
			if(EZInteraction.wasKeyReleased('s')){
				//Create a FileWriter object "fw" with a file "map.txt"
				FileWriter fw = new FileWriter("map.txt");

				//write the number of rows "rows" and columns "cols" followed by a new line to the file
				fw.write(rows + " " + cols + "\n");


				//Use a nested for loop to access each element of the "map" array
				for (int i=0; i<map.length; i++) {
					for (int j=0; j<map[i].length; j++) {
						fw.write(map[i][j].getChar());
					}
					fw.write("\n");
				}


						//write the character corresponding to the current state of the tile element
						//you may use fw.write(map[i][j].getChar())


					//Note: While writing into the file, skip to a new line every time you finish writing the characters of each row
					//for this use fw.write("\n") in the outer for loop but outside the inner for loop



				//Do not forget to close the file
				fw.close();

			}
			EZ.refreshScreen();
		}
	}

}
