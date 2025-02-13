package queueinterface.circularbuffer;

import java.util.ArrayList;
import java.util.List;

public class CircularBuffer {
    private int[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    // Add an element to the buffer (overwrites oldest if full)
    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        // If buffer is full, move head to the next element
        if (size == capacity) {
            head = (head + 1) % capacity;
        } else {
            size++;
        }
    }

    // Get the current elements in buffer as a list (in order)
    public List<Integer> getElements() {
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            elements.add(buffer[(head + i) % capacity]);
        }
        return elements;
    }
}

