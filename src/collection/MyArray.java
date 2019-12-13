package collection;

import java.util.Arrays;

public class MyArray {
    public static void main(String[] args) {
        int[] array1;
        array1 = new int[3];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        int[] array2 = new int[]{1, 2, 3};
        int[] array3 = {1, 2, 3};
        System.out.println(Arrays.equals(array1, array2));

        int[][] array4 = new int[2][3]; // 2 strings 3 rows
        int[][] table = new int[2][];
        table[0] = new int[]{1, 1, 1};
        table[1] = new int[]{2, 2};

        System.out.println(Arrays.deepToString(table));

        for (int[] rows : table) {
            for (int item : rows) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        Arrays
                .stream(table)
                .flatMapToInt(Arrays::stream)
                .forEach(System.out::println);


        int[] array = {7, 8, 9, 6, 1, 5, 3, 4};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Arrays.fill(array, 6);
        System.out.println(Arrays.toString(array));

        int i = Arrays.binarySearch(array, 2);
        System.out.println(i);

        boolean b = Arrays.deepEquals(array4, table);
        System.out.println(b);

        int[] ints = Arrays.copyOf(array, 5);
        System.out.println(Arrays.toString(ints));
    }
}