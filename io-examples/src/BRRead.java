import java.io.*;
class BRRead {
    public static void main(String args[]) throws IOException {
        char c;
        BufferedReader console = new BufferedReader(
				new InputStreamReader(System.in));
        System.out.println("Enter characters or '0' to exit.");
        do {
            c = (char) console.read();
            System.out.println(c);
        } while (c != '0');
    }
}
