import java.awt.Color;

public class VisualBar {
	static EZPolygon outerBar;
	static EZPolygon innerBar;	
	static EZLine hBar;
	
	VisualBar() { // initialize the health bar
		hBar = EZ.addLine(100, 45, 400, 45, new Color(1,45,1), 50); // 100 starting point	
	}
	
	void outlineBars() { // create the outlines of each health bar
		int[] outerOutlineX = {40, 40, 790, 790, 90, 90, 700, 700, 100, 100}; 
		int[] outerOutlineY = {30, 85, 85, 5, 5, 20, 20, 70, 70, 30 };
		
		int[] outlineX = {90, 50, 710, 750, 100, 90, 700, 700, 100, 100}; 
		int[] outlineY = {30, 80, 80, 10, 10, 20, 20, 70, 70, 30 };
				
		outerBar = EZ.addPolygon(outerOutlineX, outerOutlineY, Color.gray, true);
		innerBar = EZ.addPolygon(outlineX, outlineY, Color.black, true);
		
		EZ.addRectangle(60, 20, 80, 30, Color.LIGHT_GRAY, true);
		EZ.addRectangle(60, 20, 70, 20, Color.black, true);

	}
	
	void hpChange(int hp) { // changing the health bar relative to the input health points
		if (hp > 0) { // if the hp is greater than 0, continue the health bar functions		
			float healthPercentage = 0f;
			
			if ( hBar.getX2() < 700 ) { // if the health is less than the maximum, start a color gradient 
				hBar.setColor(new Color(  (255*(700-hp))/700 , ((255*hp)/700)   , 1)); // dynamically change the color of the health bar relative to hp
				hBar.setPoint2(100 + hp, 45);
				healthPercentage = hp/700f * 100f;
				
			} else if ( hBar.getX2() >= 700 ) {
				hBar.setPoint2(700, 45); //  keep the maximum point at the end of the bar
				healthPercentage = 100;
				// System.out.println("you are at max!");
			}
			
			EZText hpText = EZ.addText(60, 20, (int) healthPercentage + "%", Color.white, 12);
			hpText.setMsg((int) healthPercentage + "%"); // update the health bar text
			hpText.hide();
			
			/*// reference code for old gradient scheme
			if (hp < 255) {
				hBar.setColor(new Color(newBar, 1, 1));
			} else if (hp > 256 && hp < 510) {
				hBar.setColor(new Color(1, hp-255, 1)); // hBar.setColor(new Color(1, hp-255, 1));
			}
			if ( hBar.getX2() < 700 ) {
				hBar.setPoint2(100 + hp, 45);
			} else if ( hBar.getX2() >= 700 ) {
				hBar.setPoint2(700, 45);
				System.out.println("you are at max!");
			}
			*/
			
		} else if (hp <= 0) { // show the lose screen when hp is below 1
			// need to shut off program at this point and sound
			
			EZ.addRectangle(400, 400, 800, 800, Color.BLACK, true);
			EZ.addText(400, 400, "YOU LOSE", Color.BLUE, 100);
			
			// hBar.setPoint2(100 + hp, 45);
			// System.out.println("You are dead");
		}
	}
}