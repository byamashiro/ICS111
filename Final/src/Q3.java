import java.util.ArrayList;

public class Q3 {

	public static void main(String[] args) {
		int i = 0;
		ArrayList<Float> array = new ArrayList<Float>();
		
		while (i < 10) {
			array.add( new Float(i*10) );
			i++;
		}
		
		System.out.println("Original code: " + array);
		
		
		
		
		// code that includes for loop and array
		float[] array2;
		array2 = new float[10];
		
		for (int j=0; j<10; j++) {
			array2[j] = j*10;
		}
		
		for (int k=0; k<10; k++) {
			System.out.println(array2[k]);
		}
		
		

	}

}
