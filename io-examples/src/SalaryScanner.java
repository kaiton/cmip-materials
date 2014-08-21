import java.util.Scanner;

public class SalaryScanner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter your salary $: "); 
        int salary = console.nextInt();
        System.out.println(
		"Your income tax $: " + salary * 0.2);
        console.close();
    }
}



