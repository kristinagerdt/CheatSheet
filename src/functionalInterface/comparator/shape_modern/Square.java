package functionalInterface.comparator.shape_modern;

public class Square extends Shape {
    private static String displayName = "Square";

    public Square(double a) {
        super(displayName, a * a);
    }
}