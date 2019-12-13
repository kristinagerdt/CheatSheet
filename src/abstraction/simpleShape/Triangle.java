package abstraction.simpleShape;

public class Triangle extends Shape {

    private double a, b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSquare() {
        double square = (a + b) / 2;
        return Math.round(square * 100.00) / 100.00;
    }
}