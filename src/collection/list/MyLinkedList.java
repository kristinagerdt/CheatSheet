package collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MyLinkedList {
    public static void main(String[] args) {
        methodsList();
        methodsLinkedList();
        iteratorList();
    }

    private static void iteratorList() {
        List<String> list = new LinkedList<>(Arrays.asList("aa", "aa", "ab", "ac", "bb", "pp"));
        Iterator<String> iteratorPrint = list.iterator();
        while (iteratorPrint.hasNext()) {
            String item = iteratorPrint.next();
            System.out.print(item + " ");
        }
        System.out.println();

        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        Iterator<String> iteratorDelete = list.iterator();
        while (iteratorDelete.hasNext()) {
            iteratorDelete.next();
            iteratorDelete.remove();
        }
        System.out.println(list);
    }

    private static void methodsList() {
        List<String> list1 = new LinkedList<>();
        Collections.addAll(list1, "jhc", "dfbhd", "fdfd", "ffgf");
        System.out.println(list1);

        Collections.reverse(list1);
        System.out.println(list1);

        Collections.fill(list1, "b");
        System.out.println(list1);

        //if we didn't get anything from database, we should return empty List, not null
        List<String> emptyList = Collections.emptyList();

        list1.replaceAll(String::toUpperCase);
        System.out.println(list1);

        //+all the same methods like by ArrayList
    }

    private static void methodsLinkedList() {
        //ONLY for LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 5, 6, 7, 8, 9, 10));
        linkedList.addFirst(4);
        linkedList.addLast(99);
        System.out.println(linkedList);

        Integer element = linkedList.element(); //Retrieves (get), but does NOT remove, the head (first element) of this list.
        System.out.println("Element " + element);
        Integer peek = linkedList.peek(); //Retrieves, but does not remove, the head (first element) of this list.
        System.out.println("Peek " + peek);
        Integer poll = linkedList.poll(); //Retrieves and removes the head (first element) of this list.
        System.out.println("Pool " + poll);
        System.out.println(linkedList);

        linkedList.push(88); //Pushes an element onto the stack (in first place) represented by this list.
        System.out.println(linkedList);
        linkedList.offer(4); //Adds the specified element as the tail (last element) of this list.
        System.out.println(linkedList);

        Integer pop = linkedList.pop(); //Pops an FIRST element from the stack represented by this list.
        System.out.println("Pop " + pop);
        System.out.println(linkedList);

        Integer first = linkedList.getFirst();
        System.out.println("First " + first);
        Integer last = linkedList.getLast();
        System.out.println("Last " + last);
    }
}