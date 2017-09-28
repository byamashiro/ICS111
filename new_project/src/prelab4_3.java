
public class prelab4_3 {
	static int a = 10;
	static int b;
	
	public static void method() {
		System.out.println("The value of a is " + a);
		System.out.println("The value of b is " + b);
	}

	public static void main(String[] args) {
		int c = 0;
		while(c < 10) {
			method();
			a++;
			b++;
			c++;
		}

		
		

	}

}
