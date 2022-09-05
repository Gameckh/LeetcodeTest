package com.leetcode.tree;

public class MaximumDepthOfBinaryTree {

    /*
    * https://leetcode.com/problems/maximum-depth-of-binary-tree/
    *
    * 思路：
    *   利用递归，向下钻，找最大深度
    *   二叉树的递归一般都是左 - 右下探
    * */
    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        TreeNode node = TreeNode.generateTree(root, 0);
        int maxDepth = maxDepth(node);
        System.out.println(maxDepth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
