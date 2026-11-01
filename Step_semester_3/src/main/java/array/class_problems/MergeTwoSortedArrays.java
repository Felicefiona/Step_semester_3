package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int destination = 0;

        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) {
                merged[destination] = arr1[first];
                first++;
            } else {
                merged[destination] = arr2[second];
                second++;
            }
            destination++;
        }

        while (first < arr1.length) {
            merged[destination] = arr1[first];
            first++;
            destination++;
        }
        while (second < arr2.length) {
            merged[destination] = arr2[second];
            second++;
            destination++;
        }
        return merged;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int firstLength = scanner.nextInt();
            int[] arr1 = new int[firstLength];
            for (int index = 0; index < firstLength; index++) {
                arr1[index] = scanner.nextInt();
            }
            int secondLength = scanner.nextInt();
            int[] arr2 = new int[secondLength];
            for (int index = 0; index < secondLength; index++) {
                arr2[index] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));
        }
    }
}