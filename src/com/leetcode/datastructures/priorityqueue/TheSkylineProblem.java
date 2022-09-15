package com.leetcode.datastructures.priorityqueue;

import java.util.*;

public class TheSkylineProblem {

    /*
    * https://leetcode.com/problems/the-skyline-problem/
    *
    * 参考：https://blog.csdn.net/zml66666/article/details/118688749
    * 思路：
    *   1. 天际线的key point一定位于建筑的边缘，因此先获取所有建筑的边缘点，并按坐标排序
    *   2. 在此基础上，设计一个扫描线从左到右扫描各个边缘位置，获得该处最高建筑的高度，就是天际线高度
    *   3. 为快速获取最高高度，可设计一个优先队列，将该处建筑按高度从高到低进行排序。
    *      因为题中建筑已按左边缘排序，根据当前位置情况依次入队出队即可。
    * */
    public static void main(String[] args) {
//        int[][] buildings = {{0,2,3},{2,5,3}};
        int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<List<Integer>> res = getSkyline(buildings);
        for (List<Integer> point : res) {
            System.out.println(point);
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkyline_2(buildings);
    }

    public static List<List<Integer>> getSkyline_2(int[][] buildings) {
        // 建筑个数，边缘个数
        int n = buildings.length, m = n << 1; // 左移操作，相当于除以2，但只适用于正数，参考：https://www.jianshu.com/p/19ed5ff6a945
        List<List<Integer>> ans = new ArrayList<List<Integer>>();//输出答案

        int[] boundaries = new int[m];//边缘位置
        for (int i = 0; i < n; i++) {
            boundaries[i << 1] = buildings[i][0];
            boundaries[(i << 1) + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);//将建筑的边缘位置按坐标从小到大排序

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);//优先队列，a[0]为建筑右边界，a[1]为建筑高度，按高度从大到小排序
        int building = 0;//已入队建筑数量
        for (int i = 0; i < m; i++) {//遍历各个建筑边缘的位置
            if (i > 0 && boundaries[i - 1] == boundaries[i])//直接跳过重复的边缘位置
                continue;
            while (building < n && buildings[building][0] <= boundaries[i])//建筑已按左边缘排序，因此可将左边缘位于当前位置左侧的建筑依次入队
                pq.offer(new int[]{buildings[building][1], buildings[building++][2]});
            while (!pq.isEmpty() && pq.peek()[0] <= boundaries[i])//延迟删除队首范围已超出当前边缘位置的建筑
                pq.poll();
            int height = (pq.isEmpty()) ? 0 : pq.peek()[1];//空队列对应当前位置天际线高度为0
            if (ans.size() == 0 || height != ans.get(ans.size() - 1).get(1))//筛除连续相同高度的水平线
                ans.add(Arrays.asList(boundaries[i], height));
        }

        return ans;
    }

    public static List<int[]> getSkyline_1(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        height.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

}

class Pair<K, T>{
    K key;
    T value;

    public Pair() {}
    public Pair(K key, T value){
        this.key = key;
        this.value = value;
    }

    public void set(K key, T value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
