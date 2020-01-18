package collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        Collections.addAll(list, "a", "b", "a", "c", "d", "f");
        System.out.println("list: " + list);

        Collections.sort(list);
        System.out.println("sorted list: " + list);

        Collections.reverse(list);
        System.out.println("reversed list: " + list);

        Collections.fill(list, "b");
        System.out.println("list with b: " + list);

        //if we didn't get anything from database, we should return empty List, not null
        List<String> emptyList = Collections.emptyList();

        list.replaceAll(String::toUpperCase);
        System.out.println("list.toUpperCase: " + list);

        int countB = Collections.frequency(list, "B");
        System.out.println("count B: " + countB);
    }
}