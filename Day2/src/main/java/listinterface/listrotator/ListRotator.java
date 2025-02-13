package listinterface.listrotator;

import java.util.*;

public class ListRotator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        List<Integer> rotatedList = rotateList(numbers, rotateBy);
        System.out.println(rotatedList);
    }

    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;  // In case positions > size

        // Split and combine the list
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));

        return rotated;
    }
}
