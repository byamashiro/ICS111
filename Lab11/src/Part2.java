import java.awt.Color;

public class Part2 {

	public static void main(String[] args) {
		
		EZ.initialize(300, 300);
		EZ.addCircle(150, 150, 300, 300, Color.LIGHT_GRAY, true);
		EZ.addCircle(150, 150, 280, 280, Color.GRAY, true);
		EZ.addText(150, 150, "CHANGE STATE", Color.WHITE, 30);
		
		// open TrafficLight.java and implement the code from the comments
		
		// create a TrafficLight object called light with an initial state of TrafficLight.GREEN
		TrafficLight light = new TrafficLight(TrafficLight.GREEN);
		
		// each frame call light.processStates()
		while(true) {
			light.processStates();
			EZ.refreshScreen();
		}
		
		// NOTE: The console should be printing the light's current state every frame (very fast)
		
	}
	
}
