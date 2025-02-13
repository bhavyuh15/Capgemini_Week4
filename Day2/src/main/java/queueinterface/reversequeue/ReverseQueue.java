package queueinterface.reversequeue;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverseQueue(queue);
        System.out.println(queue);  // Output: [30, 20, 10]
    }

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Step 1: Remove the front element
        int front = queue.remove();

        // Step 2: Recursively reverse the remaining queue
        reverseQueue(queue);

        // Step 3: Add the removed element to the rear of the queue
        queue.add(front);
    }
}
