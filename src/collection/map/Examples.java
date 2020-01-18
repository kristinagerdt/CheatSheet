package collection.map;

import java.util.HashMap;
import java.util.Map;

public class Examples {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "Hi");
        map1.put("b", "There");
        Map<String, String> result = mapAB(map1);
        result.forEach((k, v) -> System.out.println(k + ": " + v));

        String[] strings = {"a", "b", "c", "b", "a", "d"};
        Map<String, Boolean> map2 = createMap(strings);
        map2.forEach((k, v) -> System.out.print(k + ":" + v + " "));
    }

    private static Map<String, String> mapAB(Map<String, String> input) {
        if (input.containsKey("a") || input.containsKey("b")) {
            input.put("ab", input.get("a").concat(input.get("b")));
        }
        return input;
    }

    private static Map<String, Boolean> createMap(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String item : strings) {
            if (map.containsKey(item)) {
                map.put(item, true);
            } else {
                map.put(item, false);
            }
        }
        return map;
    }
}