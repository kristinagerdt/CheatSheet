package abstraction.simpleShape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(1);
        Shape triangle = new Triangle(4, 5);
        Shape[] shapes = {circle, triangle};

        for (Shape s : shapes) {
            System.out.println(s.getSquare());
        }
    }
}