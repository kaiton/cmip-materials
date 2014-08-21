import java.io.*;

public class PrintWriterFileOutputStream {
    public static void main(String[] args) {
        PrintWriter fWriter = null;
        try {
            FileOutputStream outputStream = new FileOutputStream(
                    "c:\\Users\\Training\\Lesson7\\output.txt");
            fWriter = new PrintWriter(outputStream);
        } catch (IOException ex) {
            System.out.println("Failed to open or create the file.");
            System.out.println("Exception: " + ex.getMessage());
            System.exit(-1);
        }
        fWriter.print("a");
        fWriter.println("bcdefg");
        fWriter.close();
    }
}
