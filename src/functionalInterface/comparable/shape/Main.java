package functionalInterface.comparable.shape;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(4);
        Shape s2 = new Square(2);
        Shape s3 = new Triangle(5, 12);
        Shape[] shapes = {s1, s2, s3};
        System.out.println(Arrays.toString(shapes));

        Arrays.sort(shapes);
        Arrays
                .stream(shapes)
                .forEach(s -> System.out.println(s.getDisplayName() + " " + s.getSquare()));
    }
}