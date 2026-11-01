package array.class_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minimumPrice = prices[0];
        int maximumProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            int profit = prices[index] - minimumPrice;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
            if (prices[index] < minimumPrice) {
                minimumPrice = prices[index];
            }
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] prices = new int[length];
            for (int index = 0; index < length; index++) {
                prices[index] = scanner.nextInt();
            }
            System.out.println(maxProfit(prices));
        }
    }
}