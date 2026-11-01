package array.assigment_problems;

import java.util.Scanner;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maximumSum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (currentSum + nums[index] > nums[index]) {
                currentSum += nums[index];
            } else {
                currentSum = nums[index];
            }

            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            System.out.println(maxSubArray(nums));
        }
    }
}