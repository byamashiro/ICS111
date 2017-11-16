import java.awt.Color;

public class main {

	public static void main(String[] args) {
		EZ.initialize(800,800); // set up graphics
		EZ.setBackgroundColor(new Color(135,206,235)); // R G B
		
		visualBar bar = new visualBar();
		bar.outlineBars();
		
		/*
		for (int i=0; i<100; i++) {
			bar.hpChange(i);
			EZ.refreshScreen();
		}
		*/
		int i = 0;
		while(EZInteraction.wasKeyPressed('a') == false) {
			bar.hpChange(i);
			i++;
			EZ.refreshScreen();
		}
		

	}

}
