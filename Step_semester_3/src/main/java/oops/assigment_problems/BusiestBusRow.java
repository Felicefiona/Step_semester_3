import java.util.Scanner;
public class BusiestBusRow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < rows; i++) {
            int total = 0;
            for (int j = 0; j < cols; j++) total += sc.nextInt();
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        System.out.println("Row " + bestRow + ", Total " + bestTotal);
        System.out.println("Time: O(r*c), Additional space: O(1)");
    }
}