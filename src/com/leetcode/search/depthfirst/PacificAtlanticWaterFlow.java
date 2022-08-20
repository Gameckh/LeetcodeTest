package com.leetcode.search.depthfirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    /**
     * https://leetcode.com/problems/pacific-atlantic-water-flow/
     * 题目理解：
     *  1. 题目本身不难理解，关键是怎么关联到深度优先搜索上，要找到所有山脊，肯定要遍历路径
     *  2. 目前已知的是ocean的边界，未知的是要求的结果，所以算法应该从已知到未知，与水流向相反
     *
     * 思路：
     *  1. 矩阵按行、列来划分，从与ocean相邻的点开始检索
     *  2. 标记数组为两个boolean[][]，每个表示矩阵的一个点能否到达指定的ocean
     *  3. 辅函数负责单个point的深度优先搜索，直到把整行/列的point都检索完
     *  3. 4边分别深度优先递归，注意相邻点比大小的条件
     * */
    public static void main(String[] args) {

        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));

        int[][] heights1 = {{2,1},{1,2}};
        System.out.println(pacificAtlantic(heights1));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) return ans;
        int rowNum = heights.length, colNum = heights[0].length;
        boolean[][] checkPacific = new boolean[rowNum][colNum];
        boolean[][] checkAtlantic = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            dfs(heights, checkPacific, i, 0);
            dfs(heights, checkAtlantic, i, colNum - 1);
        }
        for (int i = 0; i < colNum; i++) {
            dfs(heights, checkPacific, 0, i);
            dfs(heights, checkAtlantic, rowNum - 1, i);
        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (checkPacific[i][j] && checkAtlantic[i][j]) {
                    List<Integer> entry = new ArrayList<>();
                    entry.add(i);
                    entry.add(j);
                    ans.add(entry);
                }
            }
        }
        return ans;
    }

    public static int[] directions = {-1, 0, 1, 0, -1};
    public static void dfs(int[][] heights, boolean[][] check, int row, int col) {
        if (check[row][col]) return;
        check[row][col] = true;
        int x, y;
        // 四个方向找一下
        for (int i = 0; i < directions.length - 1; i++) {
            x = row + directions[i];
            y = col + directions[i + 1];
            // 判断路是否通（高度差）
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length
                    && heights[row][col] <= heights[x][y]) {
                dfs(heights, check, x, y);
            }
        }
    }
}
