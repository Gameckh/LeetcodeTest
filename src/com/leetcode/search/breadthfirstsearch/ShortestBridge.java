package com.leetcode.search.breadthfirstsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestBridge {

    /**
     * https://leetcode.com/problems/shortest-bridge/
     *
     * 理解：
     *      题目实际上是要求找到矩阵中距离最短的两个1之间的距离
     * 思路：
     *      1. 广度优先：一般这种矩阵最短距离的题目都是用广度优先，因为一旦当前level找到了满足需求的路径，就不需要再深入了
     *      2. 先深度优先找到一个岛屿，深度优先的好处在于可以把整个岛屿全部找出来（找出并标记）
     *      3. 再利用广度优先，找到第二个岛屿
     *          1) 出发点：找第一个岛屿时，保存的points集合（queue）
     *          2) 外层循环是广度优先查找的轮数，外层循环执行一次，内层找完一轮
     *          3) size标记每一轮的查找次数，因为是queue，所以后offer进来的元素不受影响
     *          4) 结束条件：多轮查找后，直到找到1，就是第二个岛屿的边缘时，得到结果
     * */
    public static void main(String[] args) {

        int[][] grid = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(shortestBridge(grid));
    }

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int shortestBridge(int[][] grid) {
        Queue<int[]> points = new LinkedList<>();
        int rowNum = grid.length, colNum = grid[0].length;
        boolean[][] checked = new boolean[rowNum][colNum];

        // dfs查找第一个island
        boolean found = false;
        for (int i = 0; i < rowNum; i++) {
            if (found) break;
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == 1) {
                    dfs (grid, points, checked, i, j);
                    found = true;
                    break;
                }
            }
        }

        // 找完第一个island后，points里已经保存了所有第一个island的point
        // 接下来用breadth-first search查找最短路径
        int step = 0;
        while (!points.isEmpty()) {
            int size = points.size();
            while (size-- > 0) {
                int[] cur = points.poll();
                for (int[] dir :
                        directions) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && !checked[x][y]) {
                        if (grid[x][y] == 1) return step;
                        points.offer(new int[]{x, y});
                        checked[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void dfs (int[][] grid, Queue<int[]> points, boolean[][] checked, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || checked[i][j] || grid[i][j] == 0) return;
        checked[i][j] = true;
        points.offer(new int[]{i, j});
        for (int[] dir : directions) {
            dfs(grid, points, checked, i + dir[0], j + dir[1]);
        }
    }
}
