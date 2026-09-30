import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract LocalDate getDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        LocalDate currentDate = LocalDate.parse("2023-10-26");
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim().replace("\"", "");
            LibraryItem item = switch(type) {
                case "BOOK" -> new Book(title);
                case "DVD" -> new DVD(title);
                default -> new Magazine(title);
            };
            System.out.printf("%s: %s%n", title, item.getDueDate(currentDate));
        }
    }
}

