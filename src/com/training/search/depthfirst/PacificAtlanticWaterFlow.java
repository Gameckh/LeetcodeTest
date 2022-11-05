package com.training.search.depthfirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    /*
    * https://leetcode.com/problems/pacific-atlantic-water-flow/
    * */
    public static void main(String[] args) {

    }

    /*
    * Comprehend Problem:
    * 1. It's not hard to realize that this problem can use a depth first search solution.
    * 2. But intuitively we probably start with the unknown cells which can reach the both ocean, that would be very complex.
    * 3. So we can search from known conditions, start with the four borders of the island.
    *
    * Solution ideas:
    * 1. Set two boolean two-dimensional arrays to check whether a cell can reach the Pacific | Atlantic or not.
    * 2. Then use a depth first search function to find from every border recursively.
    * 3. Then use a double layer loop to check if a cell can reach both of the oceans, add the point to result list.
    * */
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int rLen = heights.length;
        int cLen = heights[0].length;
        boolean[][] canReach_P = new boolean[rLen][cLen];
        boolean[][] canReach_A = new boolean[rLen][cLen];
        for (int i = 0; i < rLen; i++) {
            dfs(heights, i, 0, canReach_P);
            dfs(heights, i, cLen - 1, canReach_A);
        }
        for (int i = 0; i < cLen; i++) {
            dfs(heights, 0, i, canReach_P);
            dfs(heights, rLen - 1, i, canReach_A);
        }
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (canReach_P[i][j] && canReach_A[i][j]) {
                    List<Integer> cell = new ArrayList<>(2);
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private static final int[] directions = {-1,0,1,0,-1};
    private static void dfs(int[][] heights, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) return;
        // the cell r,c can reach itself of course.
        // and this also means we checked this cell.
        canReach[r][c] = true;
        int x, y;
        int rLen = heights.length, cLen = heights[0].length;
        for (int i = 0; i < directions.length-1; i++) {
            x = r + directions[i];
            y = c + directions[i+1];
            if (x >= 0 && x < rLen && y >= 0 && y < cLen
                    && heights[r][c] <= heights[x][y]) {
                dfs(heights, x, y, canReach);
            }
        }
    }
}
