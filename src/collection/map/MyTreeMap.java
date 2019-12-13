package collection.map;

import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        //(key,value) -> (1,3)
        //sorted
        //same like HashMap, all methods
        //This collection is sorted by default and based on "red-black" trees

        Map<Integer, Integer> tree = new TreeMap<>();
        tree.put(2, 2);
        tree.put(1, 3);
        tree.put(3, 4);
        System.out.println("Tree is Sorted " + tree);

        tree.replace(3, 66);
        System.out.println(tree);

        tree.remove(1);
        System.out.println(tree);
    }
}