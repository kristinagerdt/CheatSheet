package exception;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    // 1. try-catch in the code where the error can occur
    // 2. throw new Exception in the code where the error can occur
    // 3. throw Exception after (String[] args), only catchable Exceptions

    public static void main(String[] args) {
        int[] dividers = new int[]{1, 2, 3, 0, 4, 5};
        try {
            List<Double> result = divide(10, dividers);
            System.out.println("Something went well: " + result);
        } catch (Exception e) {
            ///e.printStackTrace();
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static List<Double> divide(int number, int[] dividers) throws Exception {
        List<Double> result = new LinkedList<>();
        for (int item : dividers) {
            if (item == 0) throw new Exception("Division by zero attempt");
            result.add((double) (number / item));
        }
        return result;
    }
}