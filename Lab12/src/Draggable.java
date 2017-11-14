// Draggable class

public class Draggable {
	private String fileName;
	private EZImage img;
	private boolean isDragging;
	
	// Constructor
	// Arguments: name of image file
	//			   x position
	//			   y position
	Draggable(String fn, int x, int y) {
		fileName = fn;
		img = EZ.addImage(fn, x, y);
		isDragging = false;
	}
	
	// Getter functions
	int getX() {return img.getXCenter();}
	int getY() {return img.getYCenter();}
	String getFileName() {return fileName;}
	
	// interact
	// checks for mouse events on the image and implements
	// dragging logic.
	public void interact() {
		int clickX = EZInteraction.getXMouse();
		int clickY = EZInteraction.getYMouse();
		if (EZInteraction.wasMouseLeftButtonPressed()) {
			if (img.isPointInElement(clickX, clickY)) {
				isDragging = true;
			}
		}
		if (isDragging) {
			img.translateTo(clickX, clickY);
		}
		if (EZInteraction.wasMouseLeftButtonReleased()) {
			if (img.isPointInElement(clickX, clickY)) {
				isDragging = false;
			}
		}
		
	}
}
