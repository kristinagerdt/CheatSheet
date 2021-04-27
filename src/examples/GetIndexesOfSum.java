package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetIndexesOfSum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4};
        int target = 17;

        int[] result = getTwoIndexesOfSum(array, target);
        System.out.println(Arrays.toString(result));

        int[] resultDelta = getTwoIndexesOfSumDelta(array, target);
        System.out.println(Arrays.toString(resultDelta));
    }

    public static int[] getTwoIndexesOfSum(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] getTwoIndexesOfSumDelta(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int delta = target - array[i];
            if (map.containsKey(delta)) return new int[]{i, map.get(delta)};
            map.put(array[i], i);
        }
        return new int[]{-1, -1};
    }
}