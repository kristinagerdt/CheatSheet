package abstraction.shape;

public class Circle extends Shape {

    private static String displayName = "Circle";

    public Circle(double r) {
        super(displayName, Math.PI * r * r);
    }
}