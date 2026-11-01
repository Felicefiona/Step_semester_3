import java.util.Arrays;
import java.util.Scanner;
public class DutyRosterRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        int k = sc.nextInt() % n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) rotated[(i + k) % n] = names[i];
        System.out.println(Arrays.toString(rotated));
        System.out.println("Time: O(n), Additional space: O(n)");
    }
}