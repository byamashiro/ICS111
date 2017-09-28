package Lab4;

import java.awt.Color;

public class Challenge {

	public static void main(String[] args) {
		EZ.initialize(500,500);
		EZ.setBackgroundColor(new Color(0, 150, 0));
		Color lineColor = new Color(255, 255, 0);
		
		int x = 0;
		int y = 0;
		float alpha = 0;
		
		while (alpha < Math.PI*2) {
			System.out.print(alpha+" ");
			x = (int) (200*(float) Math.cos(alpha)) + 250;
			y = (int) (200 *(float) Math.sin(alpha)) + 250;
			EZ.addLine(250, 250, x, y, lineColor, 3);
			
			alpha += Math.PI/12;
		}
	

	}

}
