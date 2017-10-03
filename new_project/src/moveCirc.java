import java.util.Random;
import java.awt.Color;

public class moveCirc {

	public static void main(String[] args) {
		Random rand = new Random();
		
		EZ.initialize(500, 500);
		
		int circNo = 10;
		
		EZCircle[] circle = new EZCircle[circNo];
		
		for(int c=0; c<circNo; c++) {
			int randX = rand.nextInt(500);
			int randY = rand.nextInt(500);
			circle[c] = EZ.addCircle(randX, randY, 20, 20, Color.green, true);
		}


		
		while(true) {
			
			for (int i=0; i<circNo; i++) {
				circle[i].translateBy(0, 2);
			}
			
			EZ.refreshScreen();
		}

	}
}
