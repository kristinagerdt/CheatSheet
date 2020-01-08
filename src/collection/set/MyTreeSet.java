package collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        //It is based on TreeMap (k,v), but value=null
        //It's non-repeating collection of keys (k, null)
        //possible to sort
        //This collection is sorted by default and based on "red-black" trees
        Set<String> tree = new TreeSet<>();
        tree.add("aa");
        tree.add("bb");
        tree.add("cc");
        tree.add("dd");
        System.out.println(tree);

        Iterator<String> iterator = tree.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + " ");
        }

        TreeSet<String> stringTreeSet = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            stringTreeSet.add(String.valueOf(i));
        }
        System.out.println(stringTreeSet);
        //[0, 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}