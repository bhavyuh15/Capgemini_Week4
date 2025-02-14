package bufferedstream;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {
        try (BufferedInputStream Bi = new BufferedInputStream(new FileInputStream("largefile.txt"));
             BufferedOutputStream Bo = new BufferedOutputStream(new FileOutputStream("largefileoutput.txt"));) {
            byte[] buffer = new byte[1024];
            int byteread;
            while ((byteread = Bi.read(buffer)) != -1) {
                Bo.write(buffer, 0, byteread);
            }
            long endtime = System.nanoTime();
            System.out.println(endtime);
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream Fi = new FileInputStream("largefile.txt");
             FileOutputStream Fo = new FileOutputStream("output.txt");) {
            int bytes;
            while ((bytes = Fi.read()) != -1) {
                Fo.write(bytes);
            }
            long endtime = System.nanoTime();
            System.out.println(endtime);
            System.out.println("Copied the file into the new file");
        } catch (IOException e) {

            System.out.println(e.getMessage());

        }
    }
}
