package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int prefixProduct = 1;
        for (int index = 0; index < nums.length; index++) {
            products[index] = prefixProduct;
            prefixProduct *= nums[index];
        }

        int suffixProduct = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            products[index] *= suffixProduct;
            suffixProduct *= nums[index];
        }
        return products;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int index = 0; index < length; index++) {
                nums[index] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(productExceptSelf(nums)));
        }
    }
}