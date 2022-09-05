package com.leetcode.tree;

public class BalancedBinaryTree {

    /*
    * https://leetcode.com/problems/balanced-binary-tree/
    *
    * 思路：
    *   利用MaximumDepthOfBinaryTree的积累:
    *   1. 定义递归函数，计算最大深度（参考MaximumDepthOfBinaryTree）
    *   2. 中间加个判断，当Math.abs(left - right) > 1时，返回-1;
    *   3. 利用-1，判断当left或right已经等于-1时，直接向上传递即可。
    * */
    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        TreeNode node = TreeNode.generateTree(root, 0);
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        return diffDepth(root) != -1;
    }

    public static int diffDepth (TreeNode root) {
        if (root == null) return 0;
        int left = diffDepth(root.left);
        int right = diffDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
