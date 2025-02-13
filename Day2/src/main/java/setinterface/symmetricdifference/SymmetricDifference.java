package setinterface.symmetricdifference;

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> symmetricDiff = getSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff); // Output: [1, 2, 4, 5]
    }

    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);  // Union of set1 and set2

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // Intersection of set1 and set2

        result.removeAll(intersection);  // Remove the intersection from the union
        return result;
    }
}

