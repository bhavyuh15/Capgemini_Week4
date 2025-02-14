package bytearraystream;

import java.io.*;

public class ImageConverter {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";

        try {
            // Read image file into byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (FileInputStream fis = new FileInputStream(inputImagePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
            }
            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array.");

            // Write byte array back to new image file
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImagePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("New image created: " + outputImagePath);
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
