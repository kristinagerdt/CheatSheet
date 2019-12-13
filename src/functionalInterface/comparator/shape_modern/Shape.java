package functionalInterface.comparator.shape_modern;

public class Shape {
    private String displayName;
    private double square;

    public Shape(String displayName, double square) {
        this.displayName = displayName;
        this.square = square;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "displayName='" + displayName + '\'' +
                ", square=" + square +
                '}';
    }
}