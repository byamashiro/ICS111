
public class roombaC {
	String name;
	int pop;
	float popRho;

	public roombaC(String a, int b, float c) {
		name = a;
		pop = b;
		popRho = c;
	}
	
	public void print() {
		System.out.println("The island " + name + " has a population of " + pop + " and a population density of " + popRho + " per sqare mile");
	}

}
