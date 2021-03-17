package examples.sort;

import static examples.sort.Helper.fillRandom;
import static examples.sort.Helper.print;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array2 = fillRandom(1, 20, 10);
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
}