import java.util.Scanner;
public class StringInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your favorite programming language: ");
        String language = sc.nextLine();
        System.out.println("You entered: " + language);
        sc.close();
    }
}
