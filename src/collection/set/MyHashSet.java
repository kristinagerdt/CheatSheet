package collection.set;

import java.util.*;

public class MyHashSet {
    public static void main(String[] args) {
        //It is based on HashMap (k,v), but value=null
        //It's non-repeating collection of keys (k, null)
        //unsorted, unordered
        methodsSet();
        iteratorSet();
    }

    private static void methodsSet() {
        List<String> list = Arrays.asList("aa", "aa", "ab", "ac", "bb", "pp");
        Set<String> set = new HashSet<>(list);
        System.out.println(set); // order is not guaranteed

        boolean isAdd = set.add("vv");
        set.addAll(Arrays.asList("vv", "ff"));
        System.out.println(set);

        boolean isEmpty = set.isEmpty();
        System.out.println(isEmpty);

        int size = set.size();
        System.out.println(size);

        boolean isContain = set.contains("ab");
        System.out.println(isContain);

        boolean isRemove = set.remove("ac");
        System.out.println(isRemove);

        String[] strings = set.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));

        set.clear();

        //HashSet<Integer> set = new HashSet<>();
        //it has less methods than Set
    }

    private static void iteratorSet() {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "aa", "aa", "ab", "ac", "bb", "pp");
        System.out.println(set);

        //iterator is needed because of set doesn't have indexes
        Iterator<String> iteratorPrint = set.iterator();
        while (iteratorPrint.hasNext()) {
            String item = iteratorPrint.next();
            System.out.print(item + " ");
        }
        System.out.println();

        for (String item : set) {
            System.out.print(item + " ");
        }
        System.out.println();

        set.forEach(item -> System.out.print(item + " "));
        System.out.println();

        set.removeAll(Arrays.asList("ac", "bb"));
        System.out.println(set);

        Iterator<String> iteratorDelete = set.iterator();
        while (iteratorDelete.hasNext()) {
            iteratorDelete.next();
            iteratorDelete.remove();
        }
        System.out.println(set);
    }
}