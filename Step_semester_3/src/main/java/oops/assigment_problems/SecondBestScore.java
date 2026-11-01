import java.util.Scanner;
public class SecondBestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int highest = -1, second = -1;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        System.out.println(second);
        System.out.println("Time: O(n), Additional space: O(1); sorting would take O(n log n)");
    }
}