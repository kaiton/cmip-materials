import java.io.*;

public class BufferedReaderFileReader {
    public static void main(String[] args) {
        try {
            FileReader inputStream = new FileReader(
                    "c:\\Users\\Training\\FYI\\Lesson7\\output.txt");
            BufferedReader fileReader = new BufferedReader(inputStream);
            String line = fileReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = fileReader.readLine();
            }
            fileReader.close();
        } catch (IOException ex) {
            System.out.println("You got a problem!");
            System.out.println("Exception: " + ex.getMessage());
            System.exit(-1);
        }
    }
}

