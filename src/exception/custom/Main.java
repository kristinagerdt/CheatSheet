package exception.custom;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] dividers = new int[]{1, 2, -3, 0, 4, 5};
        try {
            List<Double> result = divide(10, dividers);
            System.out.println("Something went well: " + result);
        } catch (CustomDividedByZeroException e) {
            //ex.printStackTrace();
            System.out.println(e.getMessage());
            //throw e; bad practice throwing on
        } catch (NegativeInputNotAllowedException e) {
            //ex.printStackTrace();
            System.out.println(e.getMessage() + ", wrong index=" + e.getNegativeIntIndex());
        } finally {
            System.out.println("Do this anyway in block finally");
        }
        //there should be no further business logic!!

        System.out.println("!!!"); //printed only if there is no error
    }

    private static List<Double> divide(int number, int[] dividers)
            throws CustomDividedByZeroException,
            NegativeInputNotAllowedException {
        List<Double> result = new LinkedList<>();
        for (int i = 0; i < dividers.length; i++) {
            if (dividers[i] == 0) throw new CustomDividedByZeroException("Division by zero attempt");
            if (dividers[i] < 0) throw new NegativeInputNotAllowedException("Negative input not allowed", i);
            result.add((double) number / dividers[i]);
        }
        return result;
    }
}