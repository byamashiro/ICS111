package Lab4;

public class Parta {
	static float PI = 3.1415f;
	
	public static float CircumferenceOfCircle(float rad) { // a function to calculate the circumference of a circle using an input float and return a float
		float circ = PI * 2f * rad; // Circumference = 2 * PI * r^2
		return circ; // return the circumference of a circle of given radius
	}
	
	public static float AreaofSemiCircle(float r1) {
		float halfArea = AreaofCircle(r1) / 2; // enter a variable radius into the AreaofCircle function then divide quantity by two, then assign this value to halfArea
		return halfArea; // return half of the area of a circle of given radius
		
	}
	
	public static float AreaofCircle(float r) { 
		float area;
		area = PI * r * r;
		return area;
	}
	
		public static void main(String[] args) { 
			float result = 0.0f; // initialize a float for variable result
			result = AreaofCircle(2.0f); // area of circle, the input parameter is the radius
			System.out.println("Area of circle: " + result); // output area of circle to console
			
			float result_circ = 0.0f; // initialize a float for variable result_circ
			result_circ = CircumferenceOfCircle(2.0f); // circumference of circle, input parameter is radius
			System.out.println("Circumference of circle: " + result_circ); // output circumference of circle to console
			
			float result_semi = 0.0f; // initialize float for variable result_semi
			result_semi = AreaofSemiCircle(2.0f); // area of semi circle, but again using 2.0f
			System.out.println("Area of a Semi Circle: " + result_semi); // output area of semi circle to console
			
	}

}
