
public class Part1 {

	// ----------- part1 a ------------- //
	// NOTE: this variable exists in the class, Part1. So, you access it by writing 'Part1.a'.
	public static int a; // declare a static int called 'a'
	
	
	public static void main(String[] args) {
	
		int a; // delcare a local int called 'a' "this.a"
		// NOTE: this variable exists in the function main(). You access it by simply writing 'a'.
	
		Part1.a = 1; // set the value of the static 'a' to 1
		a = 2;// set the value of the local 'a' to 2
		System.out.println( a ); // println the local 'a' variable
		System.out.println( Part1.a );// println the static 'a' variable
		
		// ----------- part1 b ------------- //
	
		// open Foo.java and implement the Foo class...
	
		Foo foo1 = new Foo(); // declare a Foo object called 'foo1'
	
		System.out.println(foo1.b); // println the 'b' variable from the 'foo1' object
		System.out.println(foo1.c); // println the 'c' variable from the Foo class itself	
		foo1.funcLocal(); // call the member function, 'funcLocal' from 'foo1' 
		foo1.funcStatic(); // call the static function, 'funcStatic'
	
		Foo foo2 = new Foo(); // declare a Foo object called 'foo2'
		Foo foo3 = new Foo(); // declare a Foo object called 'foo3'

		foo2.b = 5; // set foo2's b variable to 5 accessing it via foo2.b
		
		foo2.funcLocal(); // call the member function, 'funcLocal' from 'foo2'
		foo3.funcLocal(); // call the member function, 'funcLocal' from 'foo3'
		
		// notice that each Foo object still shares the same c variable
		
	}
	
	// you have now learned the difference between static and member variables :)
	
}
