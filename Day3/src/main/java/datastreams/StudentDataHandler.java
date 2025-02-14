package datastreams;

import java.io.*;

public class StudentDataHandler {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Store student details
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);

            System.out.println("Student details saved to " + fileName);
        } catch (IOException e) {
            System.err.println("I/O error during writing: " + e.getMessage());
        }

        // Retrieve student details
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Reading student details from " + fileName + ":");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("I/O error during reading: " + e.getMessage());
        }
    }
}
