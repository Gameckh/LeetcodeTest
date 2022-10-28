package com.training.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    /*
    * Solution ideas:
    *   Much same as NonOverlappingIntervals, but this one count for overlapping number.
    *   Notice: Comparator's Lambda expression (o1, o2) -> o1 - o2 has a risk,
    * that is when o1 - o2 beyond the maximum Integer, then sort will be wrong.
    * */
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points1 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points2 = {{1,2},{2,3},{3,4},{4,5}};
        int[][] points3 = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        System.out.println(findMinArrowShots(points3));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int prev = points[0][1];
        int arrows = points.length;
        for (int i = 1; i <points.length; i++) {
            if (prev >= points[i][0]) {
                arrows--;
            } else {
                prev = points[i][1];
            }
        }
        return arrows;
    }
}
