package mapinterface.maxvaluefinder;

import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        // Input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Find the key with the highest value
        String maxKey = findMaxValueKey(inputMap);
        System.out.println("Key with the highest value: " + maxKey);  // Output: B
    }

    public static String findMaxValueKey(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}

