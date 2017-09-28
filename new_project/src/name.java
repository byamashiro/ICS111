import java.util.Scanner;
public class name {

	public static void main(String[] args) {
		String name, cont;
		
		Scanner i = new Scanner(System.in);
		System.out.println("Enter your name: ");
		name = i.nextLine();
		
		do {
			System.out.println(name);
			
			Scanner j = new Scanner(System.in);
			System.out.println("Would you like to continue? (y/n)");
			cont = j.nextLine();
		} while (cont.equals("y"));
		
		
	}

}
