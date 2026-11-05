import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] ids) {
        Set<String> seen = new HashSet<>();
        for (String id : ids) {
            if (!seen.add(id)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) ids[i] = sc.next();
        System.out.println(hasDuplicate(ids));
        System.out.println("Time: O(n) average, Space: O(n)");
        System.out.println("Alternative: nested loops use O(1) space but O(n^2) time.");
    }
}