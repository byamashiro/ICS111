
public class PancakeMain {

	public static void main(String[] args) {
		Pancake charlie = new Pancake(3, "plain", "Charlie");
		Pancake ruth = new Pancake(5, "strawberry", "Ruth");
		Pancake marge = new Pancake(2, "chocolate", "Marge");
		
		charlie.eat();
		charlie.eat();
		
		ruth.eat();
		
		marge.print();

	}

}
