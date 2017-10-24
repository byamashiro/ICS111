package deprecated;

public class roombrah {
	int posX;		//0	// Stores the x position of the probe
	int posY;			// Stores the y position of the probe
	EZImage img;
	// EZImage probePicture = EZ.addImage("probe.png", 0,0);
	// probePicture.scaleBy(0.5); // originally at 0.3
	
	

	public roombrah(String file_name, int x, int y) {
		img = EZ.addImage(file_name, x, y);
	}
	
	
	// Member functions
	public void resize() {
		img.scaleBy(0.5);
	}
	
	public void front() {
		img.pullToFront();
	}
	
	public int getX() {
		return img.getWorldXCenter();
	}
	public int getY() {
		return img.getWorldYCenter();
	}
	
	public int getWidth() {
		return img.getWorldWidth();
	}
	
	public int getHeight() {
		return img.getWorldHeight();
	}
	
	public void translate(int a, int b) {
		// img.translateTo(a, b);
		img.translateBy(a, b);
	}
	
	

}
