import java.awt.Color;

public class visualBar {
	static EZPolygon fertilizer_bar;
	static EZLine fertilizer_line;
	static EZLine fertilizer_line_2;

	
	visualBar() {
		int a = 1;
	}
	
	void outlineBars() {
		// int[] outlineX = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		// int[] outlineY = {46, 46, 58, 58, 46, 46, 60, 60, 46}; // center is located at 550
		
		int[] outlineX = {98, 98, 702, 702, 100, 100, 700, 700, 100, 100};
		int[] outlineY = {30, 42, 42, 28, 28, 30, 30, 40, 40, 30 };
		fertilizer_bar = EZ.addPolygon(outlineX, outlineY, Color.black, true);
		fertilizer_line = EZ.addLine(500, 55, 500, 55, Color.green, 4);
		fertilizer_line_2 = EZ.addLine(500, 55, 500, 55, Color.red, 4);
	}


}
