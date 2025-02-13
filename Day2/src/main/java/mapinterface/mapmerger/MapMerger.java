package mapinterface.mapmerger;

import java.util.*;

public class MapMerger {
    public static void main(String[] args) {
        // Input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println(mergedMap);  // Output: {A=1, B=5, C=4}
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1); // Start with all entries from map1

        // Merge map2 into the result
        map2.forEach((key, value) -> result.merge(key, value, Integer::sum));

        return result;
    }
}

