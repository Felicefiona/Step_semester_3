package array.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<int[]> triplets = new ArrayList<>();

        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int left = first + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(new int[] {nums[first], nums[left], nums[right]});
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        int[][] result = new int[triplets.size()][2];
        for (int index = 0; index < triplets.size(); index++) {
            result[index] = triplets.get(index);
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            int[][] triplets = threeSum(nums);
            for (int[] triplet : triplets) {
                System.out.println(Arrays.toString(triplet));
            }
        }
    }
}