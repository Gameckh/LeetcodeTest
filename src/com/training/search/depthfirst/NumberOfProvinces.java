package com.training.search.depthfirst;

public class NumberOfProvinces {

    /*
    * https://leetcode.com/problems/number-of-provinces/description/
    * */
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    /*
    * Comprehend this Problem:
    * 1. The elements on the diagonal of the matrix are cities, others are connections.
    * 2. The connections are double connected, it's not going to happen like [[1,0],[1,1]]
    *
    * Solution of this problem:
    * 1. Use depth first search of course, and we can check all connections of a province when every time the function dfs going in to out.
    * 2. Set a boolean array to check whether the current connection is checked or not to stop the recursion.
    * 3. Set an int variable count to record the cities number when every time the dfs going through.
    * */
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] checked = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                dfs(isConnected, i, checked);
                count++;
            }
        }
        return count;
    }
    
    private static void dfs( int[][] isConnected, int i, boolean[] checked ) {
        checked[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !checked[j]) {
                dfs(isConnected, j, checked);
            }
        }
    }
}
