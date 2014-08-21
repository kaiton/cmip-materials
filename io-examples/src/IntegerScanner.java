import java.util.*;

public class IntegerScanner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter integer: ");
        while (console.hasNextInt()) {
            int i = console.nextInt();
            System.out.println("You entered: " + i);
            System.out.print("Enter another integer: ");
        }
        console.close();
    }
}
