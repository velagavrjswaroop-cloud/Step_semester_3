import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CheckedUncheckedExample {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc"); // NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
        try {
            File file = new File("test.txt");
            FileReader fr = new FileReader(file); // IOException (Checked)
        } catch (IOException e) {
            System.out.println("File not found or cannot be read.");
        }
    }
}
