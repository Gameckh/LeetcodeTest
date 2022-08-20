package com.leetcode.binarysearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        if(m == 0 || n == 0) return 0;

        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;

        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public static double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {

        return 1;
    }
}
