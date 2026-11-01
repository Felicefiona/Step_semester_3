import java.util.*;
import java.time.*;
import java.time.format.*;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract int borrowingDays();
    LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(borrowingDays());
    }
}
class Book extends LibraryItem {
    Book(String title) { super(title); }
    int borrowingDays() { return 14; }
}
class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    int borrowingDays() { return 7; }
}
class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int borrowingDays() { return 3; }
}
public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, java.util.function.Function<String, LibraryItem>> types = new HashMap<>();
        types.put("BOOK", Book::new);
        types.put("DVD", DVD::new);
        types.put("MAGAZINE", Magazine::new);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' ')).toUpperCase();
            String title = line.substring(line.indexOf(' ') + 1).replace("\"", "");
            LibraryItem item = types.get(type).apply(title);
            System.out.println(item.title + ": " +
                item.dueDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        sc.close();
    }
}
