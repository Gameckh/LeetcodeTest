package com.leetcode.datastructures.graph;

public class RangeSumQueryImmutable {

    /*
    * https://leetcode.com/problems/range-sum-query-immutable/
    *
    * 思路：
    * 1. 用数组预先存储累加值，数组长度nums.length+1，状态转移方程：
    *   psum[i] = psum[i-1] + nums[i-1];
    * 2. 返回psum[right+1] - psum[left];
    * */
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
class NumArray {

    int[] psum;

    public NumArray(int[] nums) {
        psum = new int[nums.length + 1];
        for (int i = 1; i < psum.length; i++) {
            psum[i] = psum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return psum[right + 1] - psum[left];
    }
}