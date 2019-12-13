package examples;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array2 = fillRandom();
        print(array2);
        long startTime2 = System.currentTimeMillis();
        selectionSort(array2);
        long endTime2 = System.currentTimeMillis();
        print(array2);
        System.out.println("Selection sort: " + (endTime2 - startTime2) + "ms");
    }

    private static void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(i);
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                print(array);
                // Thread.sleep(100);
            }
        }
    }

    private static int[] fillRandom() {
        int size = (int) (Math.random() * 10) + 1;//1-10
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 19) + 2;//2-20
        }
        return array;
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}