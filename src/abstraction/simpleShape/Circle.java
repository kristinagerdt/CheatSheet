package abstraction.simpleShape;

public class Circle extends Shape {

    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getSquare() {
        double square = Math.PI * r * r;
        return Math.round(square * 100.00) / 100.00;
    }
}