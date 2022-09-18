package com.leetcode.datastructures.hashtable;

import java.util.HashMap;

public class MaxPointsOnALine {

    /*
    * https://leetcode.com/problems/max-points-on-a-line/
    *
    * 思路：哈希表
    * 1. 一条线可以由一个点和斜率确定下来，其中斜率 = dx/dy
    * 2. 由1可知，斜率中单独考虑dy的情况（dy不能为0）
    * 3. 内循环j从i+1开始，之前算过的点就不用再计算了
    * */
    public static void main(String[] args) {
        int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 0, sameY;
        for (int i = 0; i < points.length; i++) {
            sameY = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] == points[j][1]) {
                    sameY++;
                } else {
                    double dx = points[i][0] - points[j][0];
                    double dy = points[i][1] - points[j][1];
                    double slope = dx / dy;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            max = Math.max(max, sameY);
            for (double key : map.keySet()) {
                // 注意！这里+1是要把起始点自己算上
                max = Math.max(map.get(key)+1, max);
            }
            map.clear();
        }
        return max;
    }
}
