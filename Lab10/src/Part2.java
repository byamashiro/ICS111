
public class Part2 {
	// declare vars in public static
	public static BadGuy[] bads;
	public static int gameWidth = 5;
	public static Player mc;


	public static void main(String[] args) {
		

		
		// init vars
		bads = new BadGuy[4];
		mc = new Player();
		for(int i = 0; i < bads.length; i++) {
			bads[i] = new BadGuy(gameWidth, mc); // changed to reflect the 2 new input parameters
		}
		
		// position game objects
		mc.x = 2;
		bads[0].x = 0;
		bads[1].x = 8;
		bads[2].x = 2;
		bads[3].x = 7;
		
		// call update() on all game objects
		mc.update();
		for(int i = 0; i < bads.length; i++) {
			bads[i].update();
		}
		
	}
	
}
