package array.assigment_problems;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);
        int runningSum = 0;
        int subarrayCount = 0;

        for (int number : nums) {
            runningSum += number;
            subarrayCount += prefixFrequencies.getOrDefault(runningSum - k, 0);
            prefixFrequencies.put(runningSum, prefixFrequencies.getOrDefault(runningSum, 0) + 1);
        }
        return subarrayCount;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            System.out.println(subarraySum(nums, target));
        }
    }
}