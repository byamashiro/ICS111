package lab_3;
import java.awt.Color;


public class Parta{
		
	public static void main(String[] args ){

	EZ.initialize (400, 400);
	EZ.setBackgroundColor (new Color(0, 100, 0));

	EZImage bugPicture = EZ.addImage ("bug.png", 0, 0);
	bugPicture.rotateTo(90); // Can't divide by 0
	int stepCount = 0; 

	while(true) { //took out ";"
		if(stepCount < 80) { // added ")"
			stepCount++; // changed to an increment "++" rather than "+1"
			bugPicture.moveForward(5);
			
		}
		else{
			stepCount = 0; // Lower case "stepCount"
			bugPicture.turnLeft(90); // changed angle to 90 from 60 and the "." for the method "turnLeft()"
			
		}
			EZ.refreshScreen();
	
		}
	}

}
	