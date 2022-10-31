package com.training.search.depthfirst;

public class MaxAreaOfIsland {

    public static void main(String[] args) {

    }

    private static int[] directions = {-1, 0, 1, 0, -1};
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int x, y, area = 1;

        for (int i = 0; i < directions.length - 1; i++) {
            x = row + directions[i];
            y = col + directions[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                area += dfs(grid, x, y);
            }
        }

        return area;
    }
}
