package com.training.sorts.leetcode;

import java.util.Arrays;
import java.util.Random;

public class KthLargestElementInAnArray {

    /*
    * https://leetcode.com/problems/kth-largest-element-in-an-array/
    * */
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    /*
    * Quick Selection:
    * https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/2180600/a-guide-to-quick-select-java/
    *
    * In my own word, quick selection is:
    *
    * */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelection(nums, 0, nums.length-1, nums.length-k);
    }

    private static int quickSelection(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        return 1;
    }

    public static int partition(int[] nums, int left, int right, int pIndex) {
        return 0;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
