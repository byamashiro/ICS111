import java.awt.Color;

public class VisualBar {
	static EZPolygon outerBar;
	static EZPolygon innerBar;	
	static EZLine hBar;
	
	VisualBar() {
		// int a = 1;
		hBar = EZ.addLine(100, 45, 400, 45, new Color(1,45,1), 50); // 100 starting point
		
	}
	
	void outlineBars() {
		int[] outerOutlineX = {40, 40, 790, 790, 90, 90, 700, 700, 100, 100}; 
		int[] outerOutlineY = {30, 85, 85, 5, 5, 20, 20, 70, 70, 30 };
		
		int[] outlineX = {90, 50, 710, 750, 100, 90, 700, 700, 100, 100}; 
		int[] outlineY = {30, 80, 80, 10, 10, 20, 20, 70, 70, 30 };
				
		outerBar = EZ.addPolygon(outerOutlineX, outerOutlineY, Color.gray, true);
		innerBar = EZ.addPolygon(outlineX, outlineY, Color.black, true);
	}
	
	void hpChange(int hp) {
		if (hp > 0) {
			int newBar = hp;
			if (hp < 255) {
				hBar.setColor(new Color(newBar, 1, 1));
			} else if (hp > 256 && hp < 510) {
				hBar.setColor(new Color(1, hp-255, 1));
			}
		
			if ( hBar.getX2() < 700 ) {
				hBar.setPoint2(100 + hp, 45);
			} else if ( hBar.getX2() >= 700 ) {
				hBar.setPoint2(700, 45);
				System.out.println("you are at max!");
			}
		} else if (hp <= 0) {
			hBar.setPoint2(100 + hp, 45);
		}
	}


}