package array.class_problems;

import java.util.Scanner;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                if (nums[first] == nums[second]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            System.out.println(containsDuplicate(nums));
        }
    }
}