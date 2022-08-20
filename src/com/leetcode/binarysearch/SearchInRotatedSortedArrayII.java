package com.leetcode.binarysearch;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {

        int start = 0, end = nums.length - 1, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 如果发现左端的值与mid相同，无法证明是全部相同，还是过了折点
            if (nums[start] == nums[mid]) {
                // 解决办法简单，加1继续
                start ++;
            } else if (nums[mid] <= nums[end]) {
                // 如果mid比右端小，说明右端增序(也可能全部相同，所以是<=)
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // 否则，左端增序
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
