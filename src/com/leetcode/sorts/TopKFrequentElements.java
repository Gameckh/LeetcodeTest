package com.leetcode.sorts;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int[] nums1 = {1};
        int k = 2;
        int k1 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencies =new ArrayList<>(map.entrySet());
        frequencies.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < k; i++) {
            result[i] = frequencies.get(i).getKey();
        }
        return result;
    }
}
