
public class Arrow {
	
	private int speed;
	private EZImage arrow;
	private int life;
	
	public Arrow(int spe, String dir) {
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
		increaseLife();
	}
	
	//Perfect score when life is 74
	
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
