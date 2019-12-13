package functionalInterface.comparable.shape;

public class Shape implements Comparable<Shape> {

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
    public int compareTo(Shape o) {
        if (square > o.getSquare()) {
            return 1;
        } else if (square < o.getSquare()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "displayName='" + displayName + '\'' +
                ", square=" + square +
                '}';
    }
}