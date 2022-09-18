package com.leetcode.datastructures.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

    /*
    * https://leetcode.com/problems/longest-consecutive-sequence/
    *
    * 思路：利用哈希表，实现在O(n)的时间复杂度中解决问题
    * 1. 把所有数组值放到HashSet里
    * 2. 再次遍历nums，判断当set里不存在比当前值小1时（后续会按 +1 找，所以这里找 -1），说明这个值可以开始起算新的序列长度
    * 3. 只要set中包含num+1，继续找再+1的值，直到断掉
    * */
    public static void main(String[] args) {
        int[] nums_1 = {100,4,200,1,3,2};
        int[] nums_2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums_1));
    }

    public static int longestConsecutive(int[] nums) {
        return longestConsecutive_2(nums);
    }

    // Accepted
    public static int longestConsecutive_3(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        // 优先队列的时间复杂度低
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : nums){
            queue.offer(i);
        }
        int prev = queue.poll();
        int current = 0;
        for(int i = 1; i < nums.length; i++){
            int next = queue.poll();
            if(prev + 1 == next){
                current += 1;
            }else if(prev == next){
                continue;
            }else{
                current = 0;
            }
            result = Math.max(result, current);
            prev = next;
        }
        return result+1;
    }

    // Time Limit Exceeded
    public static int longestConsecutive_2(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestConsecutive = 0;
        while (!set.isEmpty()) {
            int cur = set.iterator().next();
            set.remove(cur);
            int next = cur + 1, prev = cur - 1;
            while (set.contains(next)) {
                set.remove(next++);
            }
            while (set.contains(prev)) {
                set.remove(prev--);
            }
            longestConsecutive = Math.max(longestConsecutive, next - prev - 1);
        }
        return longestConsecutive;
    }

    // Time Limit Exceeded
    public static int longestConsecutive_1(int[] nums) {
        if (nums.length == 0) return 0;
        int longestConsecutive = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentConsecutive = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentConsecutive++;
                }
                longestConsecutive = Math.max(longestConsecutive, currentConsecutive);
            }
        }
        return longestConsecutive;
    }
}
