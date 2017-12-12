import java.io.InputStreamReader;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		int val;
		float valf;
		String token;
		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		for (int i=0; i<11; i++) {
			token = scan.next();
		}
		
		valf = scan.nextFloat();
		token = scan.next();
		val = scan.nextInt();
		
		scan.close();
		
		System.out.println("Float is: " + valf + "  Integer is: " + val);
	}

}
