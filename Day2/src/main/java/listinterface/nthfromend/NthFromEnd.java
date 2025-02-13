package listinterface.nthfromend;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println(result);  // Output: D
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        // Move the first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                throw new IllegalArgumentException("N is larger than the list size");
            }
        }

        // Move both pointers until the first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }
}