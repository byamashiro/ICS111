
public class Arrow {
	
	private int speed;
	private EZImage arrow;
	private int life;
	
	public Arrow(int spe, String dir) {	//Spawns arrow with a given speed and direction
		speed = spe;
		switch(dir) {
		case "left":
			arrow = EZ.addImage("leftsolid.png", 160, 840);
			break;
		case "up":
			arrow = EZ.addImage("upsolid.png", 480, 840);
			break;
		case "down":
			arrow = EZ.addImage("downsolid.png", 320, 840);
			break;
		case "right":
			arrow = EZ.addImage("rightsolid.png", 640, 840);
			break;
		}
		arrow.scaleTo(0.5);
	}
	
	public void move() {
		arrow.translateBy(0, -speed);
		increaseLife();		//Increases life of the arrow to keep track of how long it's been alive which will then be used to keep track of
	}						//where it is on the screen
	
	
	
	public int returnSpeed() {
		return speed;
	}
	
	private void increaseLife() {
		life++;
	}
	
	public int returnLife() {
		return life;
	}
	
	public void remove() {
		EZ.removeEZElement(arrow);
	}
	
}
