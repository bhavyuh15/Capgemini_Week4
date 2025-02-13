package setinterface.setequalitychecker;

import java.util.*;

public class SetEqualityChecker {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        boolean isEqual = areSetsEqual(set1, set2);
        System.out.println(isEqual);  // Output: true
    }

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
}

