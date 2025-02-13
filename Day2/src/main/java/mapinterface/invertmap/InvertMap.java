package mapinterface.invertmap;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        // Input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);
        System.out.println(invertedMap);  // Output: {1=[A, C], 2=[B]}
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the value is already a key in the inverted map, add to the existing list
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }
}
