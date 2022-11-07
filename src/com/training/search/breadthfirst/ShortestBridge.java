package com.training.search.breadthfirst;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    /*
    * https://leetcode.com/problems/shortest-bridge/
    *
    * There is still a question:
    *       When use the directions = {-1, 0, 1, 0, -1} can not pass the given test case:
    *       int[][] grid = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
    * -----------------------------------------------------------------------------------
    * All right... I wrote the directions[i + 1] as directions[i] + 1... stupid
    * */
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(shortestBridge(grid));
    }

    /*
    * 1. DFS for the first island.
    * 2. BFS for the nearest 1 of the first island, because we don't need to find all the cells,
    *   we just need to find the 1 in a certain level.
    * */
    public static int shortestBridge(int[][] grid) {
        // BFS use queue to traverse the map(or tree)
        Queue<int[]> points = new LinkedList<>();
        int n = grid.length;
        // Save the status of cells so as not to duplicate check
        boolean[][] checked = new boolean[n][n];

        // A flag to mark the end of the first island search.
        boolean found = false;
        // Use DFS to find the first island.
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, points, checked, i, j);
                    found = true;
                    break;
                }
            }
        }

        int count = 0;
        // BFS outer while loop, traverse all the points in the queue.
        while (!points.isEmpty()) {
            // Inner while loop, traverse all points in the same level.
            int size = points.size();
            while(size-- > 0) {
                int[] cur = points.poll();
                // Traverse all directions of current point.
                for (int i = 0; i < directions.length - 1; i++) {
                    int x = cur[0] + directions[i];
                    int y = cur[1] + directions[i + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !checked[x][y]) {
                        if (grid[x][y] == 1) return count;
                        // If not in this level, push the point(0) into the queue, as next level.
                        points.offer(new int[]{x, y});
                        // Don't forget to mark the point status.
                        checked[x][y] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }

//    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int[] directions = {-1, 0, 1, 0, -1};

    private static void dfs(int[][] grid, Queue<int[]> points, boolean[][] checked, int x, int y){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || checked[x][y] || grid[x][y] == 0) return;

        checked[x][y] = true;
        // Save all the points of the first island, for the BFS.
        points.offer(new int[]{x, y});

        for (int i = 0; i < directions.length - 1; i++) {
            dfs(grid, points, checked, x + directions[i], y + directions[i + 1]);
        }
    }
}
