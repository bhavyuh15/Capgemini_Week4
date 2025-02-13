package setinterface.subsetchecker;

import java.util.*;

public class SubsetChecker {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean isSubset = checkSubset(set1, set2);
        System.out.println(isSubset);  // Output: true
    }

    public static boolean checkSubset(Set<Integer> subset, Set<Integer> set) {
        return set.containsAll(subset);
    }
}

