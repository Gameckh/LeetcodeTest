package com.leetcode.twopointer;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;


//        int[] nums1 = new int[]{1};
//        int[] nums2 = new int[]{};
//        int m = 1, n = 0;


//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//        int m = 0, n = 1;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int end1 = m - 1, end2 = n - 1, pos = m + n - 1;
        while (end1 >= 0 && end2 >= 0) {
            nums1[pos--] = (nums1[end1] > nums2[end2]) ? nums1[end1--] : nums2[end2--];
        }
        while (end2 >= 0) {
            nums1[pos--] = nums2[end2--];
        }
    }
}
