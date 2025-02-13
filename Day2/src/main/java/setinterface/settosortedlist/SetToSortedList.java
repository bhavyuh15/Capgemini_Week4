package setinterface.settosortedlist;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = convertToSortedList(set);
        System.out.println(sortedList);  // Output: [1, 3, 5, 9]
    }
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);  // Convert Set to List
        Collections.sort(list);  // Sort the list in ascending order
        return list;
    }
}