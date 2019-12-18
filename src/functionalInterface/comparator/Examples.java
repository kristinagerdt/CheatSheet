package functionalInterface.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        String[] strings = {"ccc", "bbb", "aaa", "ddd"};

        Comparator<String> stringComparator1 = (s1, s2) -> s1.compareTo(s2);
        Arrays.sort(strings, stringComparator1);
        System.out.println(Arrays.toString(strings));

        Comparator<String> stringComparator2 = Comparator.naturalOrder();
        Arrays.sort(strings, stringComparator2);
        System.out.println(Arrays.toString(strings));

        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Comparator<Integer> integerComparator1 = Comparator.reverseOrder();
        Arrays.sort(integers, integerComparator1);
        System.out.println(Arrays.toString(integers));

        List<Integer> integerList = new ArrayList<>(Arrays.asList(integers));
        Comparator<Integer> integerComparator2 = Comparator.naturalOrder();
        integerList.sort(integerComparator2);
        //Collections.sort(integerList,integerComparator2);
        System.out.println(integerList.toString());
    }
}