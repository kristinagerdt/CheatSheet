package examples;

public class Recursion {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(factorial(i));
            System.out.println(factorialRecursion(i));
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println(fibonacci(i));
            System.out.println(fibonacciRecursion(i));
            System.out.println(fibonacciFormula(i));
        }
    }

    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static int factorialRecursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursion(n - 1);
        }
    }

    private static int fibonacci(int ordinal) {
        int[] array = new int[ordinal + 2];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = (array[i - 1] + array[i - 2]);
        }
        return array[ordinal];
    }

    private static int fibonacciRecursion(int ordinal) {
        if (ordinal < 2) {
            return ordinal;
        } else {
            return fibonacciRecursion(ordinal - 1) + fibonacciRecursion(ordinal - 2);
        }
    }

    private static int fibonacciFormula(int ordinal) {
        double temp = (Math.sqrt(5) + 1) / 2;
        return (int) Math.round((Math.pow(temp, ordinal)) / Math.sqrt(5));
    }
}