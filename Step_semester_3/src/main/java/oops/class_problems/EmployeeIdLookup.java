import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeIdLookup {
    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String id) {
        return lookup.getOrDefault(id, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] records = new String[n][2];

        for (int i = 0; i < n; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        Map<String, String> lookup = buildLookup(records);
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.println(getDepartment(lookup, sc.next()));
        }

        System.out.println("Lookup time: O(1) average, Space: O(n)");
    }
}