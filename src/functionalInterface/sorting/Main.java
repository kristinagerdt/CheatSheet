package functionalInterface.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sorting bs = new BubbleSort();
        solution(bs);

        Sorting ss = new SelectionSort();
        solution(ss);

        //lambda-function
        Sorting bubbleSort = (int[] array) -> {
            int temp;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        };
        solution(bubbleSort);

        //anonymous class
        Sorting selectionSort = new Sorting() {
            @Override
            public void sort(int[] array) {
                int temp;
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[j] < array[i]) {
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        };
        solution(selectionSort);
    }

    private static void solution(Sorting sorting) {
        int[] array = fillRandom();
        print(array);
        sorting.sort(array);
        print(array);
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