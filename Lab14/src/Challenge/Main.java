package Challenge;

public class Main {

	public static void main(String[] args) {
		EZ.initialize(600, 600);
		
		GameObject [] objs = new GameObject[12];
		
		// Create a loop that will add 4 Banana objects
		// 4 Strawberry objects, and 4 Bomb objects
		
		
		
		while(true) {
			for (int i =0; i< 12; i++) {
				objs[i].go();
				objs[i].interact();
			}
			EZ.refreshScreen();
			
		}
		

	}

}
