package com.leetcode.search.backtracking;

public class WordSearch {

    /**
     * https://leetcode.com/problems/word-search/
     * 思路：
     * 1. 深度优先，从起点出发，找各个方向上对应位置的字符，看是否等于word在对应位置的字符
     * 2. 回溯，checked中不能只标记true，在四个方向上的dfs结束后，需要标记回false，避免影响其它路径搜索到这个字符
     * 3. dfs递归结束条件：
     *    1) 行/列的指针超出有效范围（0 ~ length-1）
     *    2) checked[行][列]被标记为true
     *    3) isFounded已经为true
     *    4) board[行][列]不等于word[position] —— 说明这条路错了，这也是回溯法的特点
     *
     * */
    public static void main(String[] args) {

        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int row = board.length, col = board[0].length;
        boolean[][] checked = new boolean[row][col];
        boolean[] isFound = new boolean[1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backtracking(i, j, board, word, checked, isFound, 0);
            }
        }
        return isFound[0];
    }

    public static int[] directions = {-1, 0, 1, 0, -1};
    public static void backtracking (int row, int col, char[][] board, String word, boolean[][] checked, boolean[] isFound, int position) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (checked[row][col] || isFound[0] || word.charAt(position) != board[row][col]) return;

        if (position == word.length() - 1) {
            isFound[0] = true;
            return;
        }

        checked[row][col] = true;
        for (int i = 0; i < 4; i++) {
            backtracking(row + directions[i], col + directions[i+1],
                    board, word, checked, isFound, position + 1);
        }
        checked[row][col] = false;
    }

}
