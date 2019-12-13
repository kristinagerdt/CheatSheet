package abstraction.shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(8, 4);
        Shape[] shapes = {circle, triangle};

        for (Shape item : shapes) {
            System.out.println(item.getDisplayName() + " " + item.getSquare());
        }
    }
}