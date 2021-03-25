package collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Demo {

    private static final Map<String, Integer> unmodifiableMap;

    static {
        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("one", 1);
        aMap.put("two", 2);
        unmodifiableMap = Collections.unmodifiableMap(aMap);
    }

    public static void main(String[] args) {
        // create Map
        Map<Object, Object> emptyMap = Collections.emptyMap();
        Map<String, Integer> map = new HashMap<>();

        // add new items
        map.put("John", 32);
        map.put("Steve", 30);
        map.put("Mary", 31);

        // create unmodifiable map
        System.out.println("Unmodifiable map:");
        unmodifiableMap.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));

        // best practice to copy map
        Map<String,Integer> copiedMap = Collections.synchronizedMap(map);

        // default methods
        int size = copiedMap.size();
        copiedMap.get("one");
        copiedMap.remove("one");
        copiedMap.clear();

        // custom methods
        getListsFromMap(map);
        iterateMap(map);
        sortMapByKey(map);
        sortMapByValue(map);
        createSortedMap(map);
    }

    private static void getListsFromMap(Map<String, Integer> map) {
        List<String> keyList = new ArrayList<>(map.keySet());
        System.out.println("Key list " + keyList);

        List<Integer> valueList = new ArrayList<>(map.values());
        System.out.println("Value list " + valueList);

        List<Map.Entry<String, Integer>> entries =  new ArrayList<>(map.entrySet());
        entries.forEach(entry -> System.out.println("k=" + entry.getKey() + ", v=" + entry.getValue()));
    }

    private static void iterateMap(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(entry -> System.out.println("k=" + entry.getKey() + ", v=" + entry.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("k=" + key + ", v=" + value);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("k=" + key + ", v=" + value);
        }
    }

    private static void sortMapByKey(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        // 1 - Comparator = anonymous class
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        Collections.sort(entries, comparator);

        // 1.1 - Entry<>.sort(comparator)
        entries.sort(comparator);

        // 2 - Comparator = anonymous class inside Collections.sort
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // 3 - Comparator = lambda expression
        Comparator<Map.Entry<String, Integer>> comparatorLambda = (o1, o2) -> o1.getKey().compareTo(o2.getKey());
        Collections.sort(entries, comparatorLambda);

        // 4 - Comparator = Comparator.comparing()
        Comparator<Map.Entry<String, Integer>> comparatorComparing = Comparator.comparing(Map.Entry::getKey);
        Collections.sort(entries, comparatorComparing);

        // 5 - Comparator = Entry.comparingByKey()
        Comparator<Map.Entry<String, Integer>> comparatorEntryComparing = Map.Entry.comparingByKey();
        Collections.sort(entries, comparatorEntryComparing);

        entries.forEach(entry -> System.out.println("k=" + entry.getKey() + ", v=" + entry.getValue()));
    }

    private static void sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
        entries.sort(comparator);

        entries.sort(Map.Entry.comparingByValue());

        entries.forEach(entry -> System.out.println("k=" + entry.getKey() + ", v=" + entry.getValue()));
    }

    private static void createSortedMap(Map<String, Integer> map) {
        Comparator<String> comparator = String::compareTo;
        SortedMap<String, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        sortedMap.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));
    }
}