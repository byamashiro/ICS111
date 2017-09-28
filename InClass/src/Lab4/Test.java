package Lab4;

public class Test {

	public static void main(String[] args) {
		int x = 100;
		int y = 1;
		String z = x + ":";
		while(y < x+1){
			if(x % y == 0){
				z += " " + y;
			}
			y++;
		}
		System.out.println(z);
	}

}
