
public class Part1 {

	public static void main(String[] args) {
		// increment by 1 from 0 to 9 and print every iteration
		for(int i = 0; i < 10; i+=1) { 
			System.out.print(i + " "); // 0 1 2 3 4 5 6 7 8 9 
		}
		
		System.out.println("\n");		// skip a line
		
		// decrement from 10 to 1 and print every iteration
		for(int i = 10; i > 0; i--) { 
			System.out.print(i + " "); // 10 9 8 7 6 5 4 3 2 1 
		}
		
		System.out.println("\n"); 		// skip a line
		
		// increment by 2 starting from 1 and print every iteration
		for(int i = 1; i <= 17; i+=2) { 
			System.out.print(i + " "); // 1 3 5 7 9 11 13 15 17 
		}
		
		System.out.println("\n");		// skip a line
		
		// increment by multiplying the iterator by 2 from 1 and print every iteration
		for(int i = 1; i <= 128; i*=2) { 
			System.out.print(i + " "); // 1 2 4 8 16 32 64 128 
		}
				
		
	}

}
