package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    /*
    * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    *
    * 思路：
    *   1. 用值作为下标访问数组，把值一一标记（标记为负数）
    *   2. 最后剩下的如果是负数，下标就是没出现过的
    * 注意：值的范围是[1,n]，换算成下标需要-1，最后添加结果的时候要+1
    * */
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
