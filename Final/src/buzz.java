
public class buzz {
	int x=10;
	
	int bar() {
		int x;
		x=3;
		return x;
	}
	
	void baz() {
		bar();
		System.out.println("The x here is: " + x);
	}
	
	public static void main(String[] args) {
		int x = 999;
		buzz obj = new buzz();
		obj.baz();
	}
	
}
