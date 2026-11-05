import java.util.Scanner;

public class LibraryCatalogLookup {
    static String findBook(String[] isbn, String[] titles, String target) {
        int low = 0, high = isbn.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = isbn[mid].compareTo(target);
            if (comparison == 0) return titles[mid];
            if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] isbn = new String[n];
        String[] titles = new String[n];

        for (int i = 0; i < n; i++) {
            isbn[i] = sc.next();
            titles[i] = sc.next();
        }

        while (sc.hasNext()) {
            System.out.println(findBook(isbn, titles, sc.next()));
        }
        System.out.println("Search time: O(log n), Space: O(1)");
    }
}