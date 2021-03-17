package examples.sort;

import static examples.sort.Helper.fillRandom;
import static examples.sort.Helper.print;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = fillRandom(1, 20, 10);
        print(array);
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        print(array);
        System.out.println("Bubble sort: " + (endTime - startTime) + "ms");
    }

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("I=" + i);
            //! inside array must be offset
            // -1 border of end
            // -i the biggest number stay at the end already
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                print(array);
                // Thread.sleep(100);
            }
        }
    }
}