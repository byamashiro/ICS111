package prelab10;

public class scope5 {

	public static void main(String[] args) {
		Bar myBar = new Bar();
		
		System.out.println( myBar.b );
		System.out.println( Bar.a );
		
		myBar.func1();
		Bar.func2();
	}

}
