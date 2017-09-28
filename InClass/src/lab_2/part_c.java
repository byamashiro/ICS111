package lab_2;
import java.awt.Color;



public class part_c {

	public static void main(String[] args) {
		
		
		// ========= Part C
		int sheep_count = 0;
		int number_iter_x = 0;
		int number_iter_y = 0;
		EZ.initialize(200, 200); // with EZ

		
		while (sheep_count < 10) {
			// System.out.println(sheep_count);
			
			number_iter_x += 15;
			number_iter_y += 15;
			
			EZText sheep = EZ.addText(number_iter_x, number_iter_y, "SHEEP", Color.RED);
			
			sheep_count += 1;
		}
		
				
		
		
			
		/* 
		int[] val = {9, 8, 13};
		
		for (int i = 0; i < val.length; i++) {
			if ((val[i] / 2)  % 2 == 0) {
				System.out.println(val + " is divisible by 2");
			} else if
		}
		*/
			
			
			
		
		
		
		
		
		
		
		

	}

}
