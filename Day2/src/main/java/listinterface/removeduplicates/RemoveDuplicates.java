package listinterface.removeduplicates;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueList = removeDuplicates(numbers);
        System.out.println(uniqueList);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer item : list) {
            if (seen.add(item)) {  // add() returns false if item is already present
                result.add(item);
            }
        }

        return result;
    }
}
