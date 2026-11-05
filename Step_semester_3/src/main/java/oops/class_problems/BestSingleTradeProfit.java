import java.util.Scanner;

public class BestSingleTradeProfit {
    static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int bestProfit = 0;

        for (int price : prices) {
            minimum = Math.min(minimum, price);
            bestProfit = Math.max(bestProfit, price - minimum);
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        System.out.println(maxProfit(prices));
        System.out.println("Single pass: O(n) time, O(1) space");
        System.out.println("Checking every pair: O(n^2) time");
    }
}