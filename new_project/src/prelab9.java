
public class prelab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============prelab===========");
		for (int a=0; a<3; a++) {
			int b =2;
			while(b<5) {
				System.out.println(b);
				b = b+1;
			}
			System.out.println("BAM! " + a);
		}
		
		System.out.println("=============1===========");

		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				System.out.print("x");
			}
			System.out.println("");
		}
		System.out.println("=============2===========");

		
		for (int a=0; a<3; a++) {
			int b = 1;
			while(b<4) {
				System.out.println(b);
				b=b+1;
			}
			System.out.println("BAM! " + a);
		}
		System.out.println("=============3===========");

		int[] arr = {1, 2, 2, 3, 1, 4, 1, 1, 4, 4, 3, 2, 2, 4, 1};
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == 1) {
				count1++;
			} else if (arr[i] == 2) {
				count2++;
			} else if (arr[i] == 3) {
				count3++;
			 }else if (arr[i] == 4) {
				count4++;
			}
		}
		
		System.out.println("1: " + count1 + " 2: " + count2 + " 3: " + count3 + " 4: " + count4);
		
		
		System.out.println("=============4===========");
		Book[] library = new Book[5];
		
		Book mockingBird = new Book("To Kill a MockingBird", "Harper Lee", 320);
		Book lordOfRings = new Book("To Kill a MockingBird", "Harper Lee", 320);
		Book londonFields = new Book("To Kill a MockingBird", "Harper Lee", 320);
		Book underworld = new Book("To Kill a MockingBird", "Harper Lee", 320);
		Book luckyJim = new Book("To Kill a MockingBird", "Harper Lee", 320);

		
		library[0] = mockingBird;
		library[1] = mockingBird;
		library[2] = mockingBird;
		library[3] = mockingBird;
		library[4] = mockingBird;

		
		for (int i=0; i<library.length; i++) {
			Book b = library[i];
			System.out.println(b.title + " by " + b.author + " " + b.numPages);
		}

	}

}
