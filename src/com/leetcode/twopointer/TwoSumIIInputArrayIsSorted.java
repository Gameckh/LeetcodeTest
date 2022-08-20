package com.leetcode.twopointer;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {

        int[] numbers1 = new int[] {2,7,11,15};
        int target1 = 9;
        int[] numbers2 = new int[] {2,3,4};
        int target2 = 6;
        int[] numbers3 = new int[] {-1, 0};
        int target3 = -1;

        System.out.println(Arrays.toString(twoSum(numbers1, target1)));
        System.out.println(Arrays.toString(twoSum(numbers2, target2)));
        System.out.println(Arrays.toString(twoSum(numbers3, target3)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int size = numbers.length;
        int left = 0;
        int right = size - 1;

        for (int i = 0; i < size; i++) {

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (sum > target) {
                right --;
            } else {
                left ++;
            }
        }

        return result;
    }
}
