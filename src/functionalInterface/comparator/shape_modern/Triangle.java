package functionalInterface.comparator.shape_modern;

public class Triangle extends Shape {
    private static String displayName = "Triangle";

    public Triangle(double a, double b) {
        super(displayName, (a + b) / 2);
    }
}