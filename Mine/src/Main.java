import java.awt.Color;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws java.io.IOException {
		
		Scanner fileScanner = new Scanner(new FileReader("level.txt"));

		int width = fileScanner.nextInt();
		int height = fileScanner.nextInt();
		String inputText = fileScanner.nextLine();

		EZ.initialize(width*32,height*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		for(int row = 0; row < height; row++){
			
			inputText = fileScanner.nextLine();
			System.out.println(inputText);
			
			for (int column = 0; column < inputText.length(); column++){
				
				char ch = inputText.charAt(column);
		
				switch(ch){
					case 'R':
						EZ.addImage("dirt.png",column*32,row*32);
						break;		
					case 'G':
						EZ.addImage("grass.png",column*32,row*32);
						break;
					case 'L':
						EZ.addImage("lava.png",column*32,row*32);
						break;
					default:
						// Do nothing
						break;
							
				}
			} 
		}	
		while(true){
			EZ.refreshScreen();
		}
	}

}
