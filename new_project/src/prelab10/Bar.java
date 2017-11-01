package prelab10;

public class Bar {
	public static int a=20;
	public int b;
	
	public Bar() {
		b=10;
	}
	
	public void func1() {
		System.out.println("Hello from an object of type Foo");
		System.out.println( Bar.a );
		System.out.println( this.b );
	}
	
	public static void func2() {
		System.out.println("Hello from the Foo class itself");
		System.out.println( Bar.a );
	}
}
