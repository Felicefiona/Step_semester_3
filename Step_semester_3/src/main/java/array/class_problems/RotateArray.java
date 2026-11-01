package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        if (nums.length == 0) {
            return newArray;
        }

        k = k % nums.length;
        for (int index = 0; index < nums.length; index++) {
            newArray[(index + k) % nums.length] = nums[index];
        }
        return newArray;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            int rotations = scanner.nextInt();
            System.out.println(Arrays.toString(rotateArray(nums, rotations)));
        }
    }
}