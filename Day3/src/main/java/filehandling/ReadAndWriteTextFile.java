package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteTextFile {
    public static void main(String[] args) {
        try (FileInputStream Fi = new FileInputStream("largefile.txt");
             FileOutputStream Fo = new FileOutputStream("output.txt");) {
            int bytes;
            while ((bytes = Fi.read()) != -1) {
                Fo.write(bytes);
            }
            System.out.println("Copied the file into the new file");
        }
catch(IOException e){

            System.out.println(e.getMessage());

            }
        }
    }

