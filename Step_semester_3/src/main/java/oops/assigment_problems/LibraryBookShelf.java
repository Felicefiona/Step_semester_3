import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookShelf {
    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = newBook;
            System.out.println("After placing " + newBook + ": " +
                    Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] books = new int[n];
        for (int i = 0; i < n; i++) books[i] = sc.nextInt();
        shelf(books);
    }
}