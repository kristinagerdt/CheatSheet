package examples;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(array, 2));
    }

    private static int binarySearch(int[] array, int value) {
        for (int left = 0, right = array.length - 1; left <= right; ) {
            int mid = left + (right - left) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}