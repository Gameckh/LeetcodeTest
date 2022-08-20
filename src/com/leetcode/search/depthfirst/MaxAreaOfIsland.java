package com.leetcode.search.depthfirst;

import java.util.Arrays;

public class MaxAreaOfIsland {

    /**
     * https://leetcode.com/problems/max-area-of-island/
     *  思想：深度优先搜索
     *  思路：
     *      主函数遍历所有元素（两层循环），辅函数递归
     *      1. 主函数中调用辅函数前先判断，减少调用栈数量
     *      2. 主函数maxArea = Math.max(maxArea, dfs)这句好理解，找出所有1元素所属岛屿中最大的一个岛屿
     *      3. directions数组，相邻两个元素表示一个方位，比如{-1, 0}表示同一列上一行的元素，{0, -1}表示同一行上一列元素（SpreadJS）
     *      4. 辅函数的grid[row][col] = 0; 是为了不无限递归，因为走到下一个相邻的1时，还需要再回来找判断过的元素，所以标记后可以避免无线递归
     *      5. 辅函数的area += dfs() 表示在一个1的所有方位上所有1的个数，整个岛屿需要把这些1都叠加在一起，才是完整的区域面积。
     * */
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
        System.out.println(Arrays.deepToString(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public static int[] directions = {-1, 0, 1, 0, -1};
    public static int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int x, y, area = 1;
        for (int i = 0; i < directions.length - 1; i++) {
            x = row + directions[i];
            y = col + directions[i+1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length)
                area += dfs(grid, x, y);
        }
        return area;
    }

}
