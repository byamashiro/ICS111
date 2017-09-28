import java.awt.Color; // needed for EZ

public class HelloWorld {

	public static void main(String[] args) {
		// String s;
		// System.out.println("" + s);
		
		System.out.println("Hello World"); // without EZ 
		
		EZ.initialize(200, 200); // with EZ
		EZ.addText(100,  100, "Hello World", Color.BLACK);
		// TODO Auto-generated method stub		
		

	}

}
