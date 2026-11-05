import java.util.Scanner;

public class WarehouseBinGridScan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int total = 0, max = -1, maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = sc.nextInt();
                total += value;
                if (value > max) {
                    max = value;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Total: " + total);
        System.out.println("Max coordinate: (" + maxRow + ", " + maxCol + ")");
        System.out.println("Time: O(m*n), Additional space: O(1)");
    }
}