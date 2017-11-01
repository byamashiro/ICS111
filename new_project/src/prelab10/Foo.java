package prelab10;

public class Foo {
	public static int g = 10;
	public int a;
	
		Foo(){
			int a = 1;
		}
		
		void print() {
			System.out.println(a);
		}
		
		void print2(int a) {
			System.out.println(a);
		}
		
		void print3(int a) {
			System.out.println(this.a);
		}
		
		void print4() {
			System.out.println(g);
		}
		
		void set() {
			a = 3;
		}
		
		void set2() {
			int a = 4;
		}
		
		void set3(int a) {
			a = this.a;
		}
		
		void set4(int a) {
			this.a = a;
		}

}
