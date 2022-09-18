package com.leetcode.datastructures.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    * https://leetcode.com/problems/two-sum/
    *
    * 思路：用哈希表解决
    * */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hash.get(target - nums[i]);
                return res;
            }
            hash.put(nums[i], i);
        }
        return res;
    }
}
