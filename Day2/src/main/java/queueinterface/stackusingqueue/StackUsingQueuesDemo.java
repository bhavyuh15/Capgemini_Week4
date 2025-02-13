package queueinterface.stackusingqueue;

import java.util.*;

class StackUsingQueues {
    // Two queues for implementing the stack
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        // Add new element to queue2
        queue2.add(x);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return queue1.remove();
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueuesDemo {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push operations
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop operation
        System.out.println(stack.pop());  // Output: 3

        // Top operation
        System.out.println(stack.top());  // Output: 2

        // Pop and check empty
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty());  // Output: false
        System.out.println(stack.pop());  // Output: 1
        System.out.println(stack.isEmpty());  // Output: true
    }
}

