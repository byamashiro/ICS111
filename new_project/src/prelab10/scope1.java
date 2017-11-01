package prelab10;

public class scope1 {

	public static void main(String[] args) {
		Foo foo = new Foo();
		Foo foo2 = new Foo();
		
		foo.print();
		foo.print2(7);
		foo.print3(8);
		
		foo.set();
		foo.print();
		
		foo.set2();
		foo.print();
		
		foo.set3(5);;
		foo.print();
		
		foo.set4(6);
		foo.print();
		
		foo.print4();
		foo2.print4();
		
		Foo.g = 11;
		
		foo.print4();
		foo2.print4();
		
		

	}

}
