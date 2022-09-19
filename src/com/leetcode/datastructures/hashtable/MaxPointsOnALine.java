package com.leetcode.datastructures.hashtable;

import java.util.HashMap;

public class MaxPointsOnALine {

    /*
    * https://leetcode.com/problems/max-points-on-a-line/
    *
    * 思路：哈希表
    * 1. 一条线可以由一个点和斜率确定下来，其中斜率 = dx/dy (或dy/dx，统一算法即可)
    * 2. 内循环同样从0开始，同时排除 i==j 的情况
    * 3. 当x2 == x1时，slope为 Infinity，也可以作为map的key
    * 4. 由于内循环从0开始，当已经计算过的点被重复计算时，slope为负值，不影响max
    * */
    public static void main(String[] args) {
        int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        int[][] points_1 = {{0,1},{0,0},{0,4},{0,-2},{0,-1},{0,3},{0,-4}};
        int[][] points_2 = {{2,1},{2,2},{2,3}};
        System.out.println(maxPoints(points_2));
    }

    public static int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double x1 = points[i][0];
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];
                // 当
                double slope = (y2 - y1) / (x2 - x1);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                }else {
                    map.put(slope, 2);
                }
                max = Math.max(max, map.get(slope));
            }
        }
        return max;
    }
}
