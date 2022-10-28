package com.training.greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

    /*
    * Given an array of intervals intervals where intervals[i] = [starti, endi],
    * return the minimum number of intervals you need to remove to make the rest
    * of the intervals non-overlapping.
    *
    * Resolve Ideas:
    *   Since we want to find the overlapping intervals elements, we'd better sort the Intervals by end,
    * and find if the right element's start is smaller than the left element's end, if it is, delete the right one.
    *   As we see the key step of this solution is sort by end, but why we should do this?
    *   Because the end value of the intervals decided the scope of the span of the interval.
    * 1. Sort the intervals by end. Notice that the second parameter of the Arrays.sort() is a Lambda expression.
    * 2. Traverse the sorted intervals, then delete the overlapping elements by comparing result of the previous end and next start.
    *       NOTICE: The previous end should be saved out of the loop because when we deleted an element,
    *   the previous end will continuously compare with the start next to the deleted one.
    * */
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals1 = {{1,2}, {1,2}, {1,2}, {1,2}};
        int[][] intervals2 = {{1,2}, {2,3}};
        int[][] intervals3 = {{1,100}, {11,22}, {1,11}, {2,12}};

        System.out.println(eraseOverlapIntervals(intervals3));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int delete = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                delete++;
            } else {
                prev = intervals[i][1];
            }
        }
        return delete;
    }
}
