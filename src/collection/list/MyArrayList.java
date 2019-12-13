package collection.list;

import java.util.*;
import java.util.stream.Collectors;

public class MyArrayList {
    public static void main(String[] args) {
        methodsList();
        methodsArrayList();
        iteratorList();
    }

    private static void methodsList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        Integer item = list1.get(0);
        System.out.println(item);

        List<Integer> collectedList = list1
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collectedList);

        int size = list1.size();
        System.out.println(size);

        boolean b = list1.contains(2);
        System.out.println(b);

        list1.clear();

        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 6, 4, 7, 1));
        list1.addAll(list2);
        System.out.println(list1);

        Collections.sort(list1);
        System.out.println(list1);

        boolean equals = list1.equals(list2);
        System.out.println(equals);

        int index = list1.indexOf(2);
        System.out.println(index);

        list1.remove(3);
        System.out.println(list1);

        list1.replaceAll(i -> i + 2);
        System.out.println(list1);

        boolean isEmpty = list1.isEmpty();
        System.out.println(isEmpty);

        List<Integer> subList = list1.subList(0, 2);
        System.out.println(subList);

        list1.set(2, 99);
        System.out.println(list1);

        Integer[] integers = list1.toArray(new Integer[0]);

        System.out.println(Arrays.toString(list1.toArray()));
    }

    private static void methodsArrayList() {
        //ONLY for ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 5, 7, 8, 9, 63, 1, 4));
        arrayList.forEach(System.out::println);
        arrayList.sort(Integer::compareTo);
        System.out.println(arrayList);
    }

    private static void iteratorList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 5, 7, 8, 9, 1, 4, 5, 5));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.print(item + " ");
        }
    }
}