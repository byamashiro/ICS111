
public class BadGuy {

	public static String fallString = "I fell";
	
	public int x;
	public int gameWidth = Part2.gameWidth;
	public Player mcRef = Part2.mc;
	
	public BadGuy(int gameWidth, Player mcRef) {
		this.gameWidth = gameWidth;
		this.mcRef = mcRef;
		
	}
	
	public void update() {		
		// if mc.x (from Part2.java) and my x are the same, then println "uh oh!"
		if (Part2.mc.x == x) {
			System.out.println("uh oh!");
		}
		// if x < 0 or x > gameWidth from Part2.java, then println BadGuy.fallString
		if ( x < 0 || x > Part2.gameWidth) {
			System.out.println(BadGuy.fallString);
		}
	}

}
