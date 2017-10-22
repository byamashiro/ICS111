
public class IslandMain {

	public static void main(String[] args) {
		
		// Create an Island object for Oahu
		Island Oahu = new Island("Oahu", 953207, 1597.46f);
		
		// Create an Island object for Maui
		Island Maui = new Island("Maui", 144444, 198.63f);
		
		// Create an Island object for Lanai
		Island Lanai = new Island("Lanai", 3135, 22.313f);
		
		// call print() for each of the three objects
		Oahu.print();
		Maui.print();
		Lanai.print();

	}

}
