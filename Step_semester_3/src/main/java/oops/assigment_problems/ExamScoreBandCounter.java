import java.util.Scanner;
public class ExamScoreBandCounter {
    static int lowerBound(int[] a, int target) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    static int upperBound(int[] a, int target) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt(), high = sc.nextInt();
        System.out.println(upperBound(scores, high) - lowerBound(scores, low));
        System.out.println("Linear scan: O(n); Binary search: O(log n); Additional space: O(1)");
    }
}