package com.leetcode.search.depthfirst;

import java.util.Arrays;

public class NumberOfProvinces {


    /**
     * 思想：深度优先搜索，Depth-first search (dfs)
     *
     * 题目理解：
     *  1. 一共n个city，所以矩阵是n个元素，矩阵描述的是city的connections，所以矩阵是n * n的
     *  2. 每个city表示1，所以矩阵的对角线都是1，并且全无联系的情况下，每一列只有1个1
     *  3. 连接是双向的，如果a和b两个city是连通的，表示b和a也是连通的，体现在矩阵里就是[[1, 1], [1, 1]]，不会出现[[1, 0], [1, 1]]这种情况
     *
     * 思路：
     *  1. 从分析可知，一共n个城市，分布在对角线上，每个city最多n条边，最少1条边(跟自己连通)
     *  2. 声明一个n个元素的boolean数组checked，表示已经查找过的边，它是递归的flag
     *  3. 深度优先遍历矩阵，出来一次，说明一个province找完了，count++，如果一次把所有关系都找完了，checked遍历完都不会再count++了
     *  4. 辅函数第一句先改checked为true，因为checked是递归结束的flag，最后的count不用checked统计
     * */
    public static void main(String[] args) {

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));

        isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] checked = new boolean[isConnected.length];
        for (int i = 0; i <checked.length; i++) {
            if (!checked[i]) {
                // 深度优先遍历矩阵，出来一次，说明一个province找完了，count++
                dfs(isConnected, i, checked);
                count++;
            }
        }
        // 可以看到connected都是true
        System.out.println(Arrays.toString(checked));
        return count;
    }

    public static void dfs (int[][] isConnected, int i, boolean[] checked) {
        checked[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !checked[j]) {
                dfs(isConnected, j, checked);
            }
        }
    }
}
