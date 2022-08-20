package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

//        int[][] intervals = new int[][]{ new int[]{1,2}, new int[]{2,3}, new int[]{3, 4}};
//        int[][] intervals = new int[][]{ new int[]{1,2}, new int[]{2,3}, new int[]{3, 4}, new int[]{1, 3}};
//        int[][] intervals = new int[][]{ new int[]{1,2}, new int[]{1,2}, new int[]{1, 2}, new int[]{1, 2}};
        int[][] intervals = new int[][]{ new int[]{1,100}, new int[]{11,22}, new int[]{1, 11}, new int[]{2, 12}};
        System.out.println(eraseOverlapIntervals(intervals));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        int removed = 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int prev = intervals[0][1];
        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < prev) {
                removed ++;
            } else {
                prev = intervals[i][1];
            }
        }

        return removed;
    }
}
