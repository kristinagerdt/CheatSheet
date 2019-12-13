package functionalInterface.comparable.shape;

public class Circle extends Shape {

    private static String displayName = "Circle";

    public Circle(double r) {
        super(displayName, Math.round((Math.PI * r * r) * 100.0) / 100.0);
    }
}