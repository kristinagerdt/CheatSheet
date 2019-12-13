package functionalInterface.comparator.shape_modern;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(4);
        Shape s2 = new Triangle(5, 12);
        Shape s3 = new Square(5);
        Shape[] shapes = {s1, s2, s3};

        System.out.println("Before:");
        print(shapes);

        //anonymous class, sort by DisplayName
        Comparator<Shape> comparatorDN = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        };
        Arrays.sort(shapes, comparatorDN);
        System.out.println("\nAfter sort by DisplayName:");
        print(shapes);

        //lambda-function, sort by DisplayName
        Comparator<Shape> comparatorLambdaDN = (o1, o2) -> o1.getDisplayName().compareTo(o2.getDisplayName());
        Arrays.sort(shapes, comparatorLambdaDN);
        System.out.println("\nAfter sort by DisplayName:");
        print(shapes);

        //lambda-function, Comparator.comparing, sort by DisplayName
        Comparator<Shape> comparatorShortLambdaDN = Comparator.comparing(Shape::getDisplayName);
        Arrays.sort(shapes, comparatorShortLambdaDN);
        System.out.println("\nAfter sort by DisplayName:");
        print(shapes);


        //anonymous class, sort by Square
        Comparator<Shape> comparatorS = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.getSquare(), o2.getSquare());
            }
        };
        Arrays.sort(shapes, comparatorS);
        System.out.println("\nAfter sort by Square:");
        print(shapes);

        //lambda-function, sort by Square
        Comparator<Shape> comparatorLambdaS = (o1, o2) -> Double.compare(o1.getSquare(), o2.getSquare());
        Arrays.sort(shapes, comparatorLambdaS);
        System.out.println("\nAfter sort by Square:");
        print(shapes);

        //lambda-function, Comparator.comparing, sort by Square
        Comparator<Shape> comparatorShortLambdaS = Comparator.comparing(Shape::getSquare);
        Arrays.sort(shapes, comparatorShortLambdaS);
        System.out.println("\nAfter sort by Square:");
        print(shapes);
    }

    private static void print(Shape[] shapes) {
        Arrays
                .stream(shapes)
                .forEach(s -> System.out.println(s.getDisplayName() + " " + s.getSquare()));
    }
}