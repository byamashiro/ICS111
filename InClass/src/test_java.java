
public class test_java {

	public static void main(String[] args) {
		
		int a = 1;
		
		System.out.println("a (before): " +  a);
		System.out.println("a++: " + (a++));
		System.out.println("a (between): " + a);
		System.out.println("++a: " + (++a));	
		System.out.println("a (after): " + a);
		
		int b = 10;
		int c = 20;
		
		System.out.println("a + b: " + (b+c++));
		
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int i = 0;
		for (i = 0; i <= 10; i++) {
			System.out.println("printing..." + i);
		}
		
		System.out.println(i);
		
		// test increments
		int foo = -3;
		int gee = -4;
		int baa = 3;
		
		
		baa = foo++ + 4;
		
		System.out.println(foo + " " + gee + " " + baa);
		
		// test string concatenation
		String str2 = "Number" + (13 + 7);
		
		System.out.println(str2);
		
		// float declaration
		float j = 1;
		
		System.out.println(j);
		
		// System.out.println(j.class().getName());
		//j.getClass().getName(); //.getSimpleName() on non-primitive types
		
		

	}

}
