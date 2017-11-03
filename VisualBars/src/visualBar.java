import java.awt.Color;

public class visualBar {
	static EZPolygon fertilizer_bar;
	static EZPolygon fertilizer_bar2;
	static EZPolygon ticks;

	static EZCircle multCirc;
	

	static EZLine fertilizer_line;
	static EZLine fertilizer_line_2;

	
	visualBar() {
		int a = 1;
	}
	
	void outlineBars() {
		// int[] outlineX = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		// int[] outlineY = {46, 46, 58, 58, 46, 46, 60, 60, 46}; // center is located at 550
		
		// rectangle outline
		// int[] outlineX = {90, 90, 710, 710, 100, 100, 700, 700, 100, 100}; 
		// int[] outlineY = {30, 80, 80, 10, 10, 20, 20, 70, 70, 30 };
		
		// diagonal outline
		int[] outerOutlineX = {70, 40, 740, 790, 90, 80, 730, 700, 70, 100}; 
		int[] outerOutlineY = {30, 85, 85, 5, 5, 20, 20, 70, 70, 30 };
		
		int[] outlineX = {90, 50, 710, 750, 100, 90, 730, 700, 70, 100}; 
		int[] outlineY = {30, 80, 80, 10, 10, 20, 20, 70, 70, 30 };
		
		int a = 100;
		int b = 0;
		
		int[] tickX = {70, 75+a, 75+a, 70};
		int[] tickY = {70, 70, 20, 20};
		
		ticks = EZ.addPolygon(tickX, tickY, Color.red, true);
		
		fertilizer_bar = EZ.addPolygon(outerOutlineX, outerOutlineY, Color.gray, true);
		fertilizer_bar2 = EZ.addPolygon(outlineX, outlineY, Color.black, true);
		multCirc = EZ.addCircle(85, 22, 40, 40, Color.blue, true);

		fertilizer_line = EZ.addLine(500, 55, 500, 55, Color.green, 4);
		fertilizer_line_2 = EZ.addLine(500, 55, 500, 55, Color.red, 4);
	}


}
