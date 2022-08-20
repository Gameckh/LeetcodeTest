package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = new int[][]{ new int[]{10,16}, new int[]{2,8}, new int[]{1, 6}, new int[]{7, 12}};
        int[][] points1 = new int[][]{ new int[]{1,2}, new int[]{3,4}, new int[]{5, 6}, new int[]{7, 8}};
        int[][] points2 = new int[][]{ new int[]{1,2}, new int[]{2,3}, new int[]{3, 4}, new int[]{4, 5}};

        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        int[][] points3 = new int[][]{ new int[]{-2147483646, -2147483645}, new int[]{2147483646, 2147483647}};
//        System.out.println(findMinArrowShots(points));
//        System.out.println(findMinArrowShots(points1));
//        System.out.println(findMinArrowShots(points2));
        System.out.println(findMinArrowShots(points3));
    }

    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = 0;
                if (o1[1] > o2[1]) result = 1;
                if (o1[1] < o2[1]) result = -1;
                return result;
            }
        });

        int len = points.length;
        int prev = points[0][1];
        int arrows = 1;

        for (int i = 1; i < len; i++) {
            if (points[i][0] > prev) {
                arrows ++;
                prev = points[i][1];
            }
        }

        return arrows;
    }
}
