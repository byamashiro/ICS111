

public class DonutShapeMain {
    public static void main(String[] args) {
        DonutShape donut1 = new DonutShape(3, 4);
        DonutShape donut2 = new DonutShape(2, 5);
        DonutShape donut3 = new DonutShape(1.5f, 3.2f);
        
        // print them and their area
        donut1.print();
        donut2.print();
        donut3.print();
        
        System.out.println(donut1.r2 + " " + donut2.r2);
    }

}