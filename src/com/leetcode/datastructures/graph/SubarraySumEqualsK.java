package com.leetcode.datastructures.graph;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /*
    * https://leetcode.com/problems/subarray-sum-equals-k/
    *
    * 思路：
    * 1. 利用Hash table存储前缀和，其中key是前缀和，value是出现的次数
    * 2. 初始化map.put(0, 1); 以便于中间判断
    * */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1,1,2,2};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int total = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;

            if (map.containsKey(rem)) {
                total += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
