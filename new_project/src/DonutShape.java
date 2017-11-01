
public class DonutShape {
    float r1; // the radius of inner circle
    float r2; // the radius of outer circle
    
    float PI = 3.14f;
    
    DonutShape(float inner_r, float outer_r) {
        r1 = inner_r;
        r2 = outer_r;
    }

    float area() {
        return PI * r2 * r2 - PI * r1 * r1;
    }
    
    // prints radius values and area of donut
    void print() {
        float a = area();
        System.out.println("Donut with inner radius "+r2+" and outer radius "+r1+" has area of "+a);
    }

}