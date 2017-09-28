package lab_2;
import java.awt.Color;


public class lab_2_challenge {

	public static void main(String[] args) {

		int column_count = 0;
		int number_iter_x = 0;
		
		EZ.initialize(200, 200); // with EZ

		
		while (column_count < 4) {
			int row_count = 0;
			int number_iter_y = 0;
			number_iter_x += 30;
			
			while (row_count < 5) {
				
				System.out.println(column_count);
				
				// number_iter_x += 12;
				number_iter_y += 15;
				
				
				EZText sheep = EZ.addText(number_iter_x, number_iter_y, "SHEEP", Color.RED);
				
				row_count += 1;
			
				}
			column_count += 1;

		}

	}

}
