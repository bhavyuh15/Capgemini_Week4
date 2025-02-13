package queueinterface.circularbuffer;

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        // Insert elements
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.getElements());  // Output: [1, 2, 3]

        // Insert another element, oldest (1) will be overwritten
        buffer.add(4);
        System.out.println(buffer.getElements());  // Output: [2, 3, 4]

        // Continue inserting
        buffer.add(5);
        buffer.add(6);
        System.out.println(buffer.getElements());  // Output: [4, 5, 6]
    }
}
