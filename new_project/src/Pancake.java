
public class Pancake {

		int amount;
		String topping;
		String customer;
		
		Pancake(int a, String t, String c) {
			amount = a;
			topping = t;
			customer = c;
			print();
		}
		
		void print() {
			System.out.println(customer + " has " + amount + " " + topping + " pancakes");
		}
		
		void eat() {
			if (amount > 0) {
				amount--;
				print();
			}
		}

}
