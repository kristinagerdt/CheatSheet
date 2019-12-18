package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
    public static void main(String[] args) {
        //(key,value) -> (1,3)
        //unsorted, unordered
        methods();
        fill();
        print();
    }

    private static void methods() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(2, 1);
        map.put(1, 1);
        map.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));
        map.entrySet().forEach(entry -> System.out.println("k=" + entry.getKey() + " v=" + entry.getValue()));
        System.out.println(map.toString());

        Set<Integer> keys = map.keySet(); //keys
        System.out.println(keys);
        Collection<Integer> values = map.values(); // values
        System.out.println(values);

        for (Integer key : map.keySet()) {
            String value = map.get(key).toString();
            System.out.println(key + " " + value);
        }

        Integer getOrDefault = map.getOrDefault(4, 66);
        System.out.println("getOrDefault " + getOrDefault);

        map.putIfAbsent(4, 4);
        System.out.println(map);

        Map<Integer, Integer> mapAdditional = new HashMap<>();
        map.put(6, 6);
        map.put(7, 3);
        map.putAll(mapAdditional);
        System.out.println(map);

        map.computeIfPresent(2, (key, value) -> value + 2);
        map.computeIfAbsent(9, key -> key + 1);

        System.out.println(map);
    }

    private static void fill() {
        String[] strings = {"a", "b", "b", "c", "c"};
        Map<String, Integer> map = new HashMap<>();
        for (String item : strings) {
            if (map.containsKey(item)) {
                Integer value = map.get(item);
                value++;
                map.put(item, value);
            } else {
                map.put(item, 1);
            }
        }
        System.out.println(map);
    }

    private static void print() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // 1. using Iterator
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 2. For-each Loop
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // 3. Java 8 - Collection.iterator() + Iterator.forEachRemaining()
        map.keySet()
                .iterator()
                .forEachRemaining(System.out::println);

        map.values()
                .iterator()
                .forEachRemaining(System.out::println);

        // 4. Java 8 - Collection.stream() + Stream.forEach()
        map.keySet().forEach(System.out::println);
    }
}