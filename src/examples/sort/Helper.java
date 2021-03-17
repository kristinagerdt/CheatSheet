package examples.sort;

import java.util.Arrays;

public class Helper {
    public static int[] fillRandom(int min, int max, int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return array;
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}