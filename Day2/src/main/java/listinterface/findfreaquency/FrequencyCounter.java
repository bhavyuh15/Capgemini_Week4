package listinterface.findfreaquency;

import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = getFrequency(fruits);
        System.out.println(frequencyMap);
    }

    public static Map<String, Integer> getFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
}
