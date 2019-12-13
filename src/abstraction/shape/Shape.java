package abstraction.shape;

public abstract class Shape {

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
        return Math.round(square * 100.0) / 100.0;
    }
}