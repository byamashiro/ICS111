
public class Foo {

	static int c = 0; // declare a static member variable of type int called 'c' and set it to 0
	// NOTE: this variable exists in the class, Foo. So, you access it by writing 'Foo.c' or just 'c'. The 'Foo' is implied.
	
	int b; // declare a local member variable of type int called 'b'
	// NOTE: this variable exists in the objects that are created from this class. You access it by writing 'this.b' or just 'b'. The 'this' is implied.
	
	
	// declare a constructor that takes no parameters, and does the following...
		// set 'b' to 4
		// increment 'c' by 1
	Foo() {
		b = 4;
		c++;
	}
	
	// declare a local member function of type void called 'funcLocal' that takes no parameters, and does the following...
		// println "Hello from an object of type Foo"
		// println the value of 'c' (if you write just 'c', 'Foo.c' is implied, try both!)
		// println the value of 'b' (if you write just 'b', 'this.b' is implied, try both!)
	void funcLocal() {
		System.out.println("Hello from an object of type Foo");
		System.out.println( c );
		System.out.println( b );
	}
	
	// declare a static member function of type void called 'funcStatic' that takes no parameters, and does the following...
		// println "Hello from the Foo class itself"
		// println the value of 'c' (if you write just 'c', 'Foo.c' is implied)
		// try to println the value of 'b'. why doesn't this work? Your TA will explain this.
	static void funcStatic() {
		System.out.println("Hello from the Foo class itself");
		System.out.println( c );
		// System.out.println( b );
	}
	
}
