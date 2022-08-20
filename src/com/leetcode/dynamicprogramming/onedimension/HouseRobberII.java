package com.leetcode.dynamicprogramming.onedimension;

public class HouseRobberII {
    public static void main(String[] args) {

        int[] nums = {2,3,2};
        System.out.println(new HouseRobberII().rob(nums));

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob1(nums), rob2(nums));
    }

    public int rob1(int[] nums){
        int preMax = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return curMax;
    }

    public int rob2(int[] nums){
        int preMax = 0, curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return curMax;
    }
}
