package com.leetcode.tree;

public class DiameterOfBinaryTree {

    /*
    * https://leetcode.com/problems/diameter-of-binary-tree/
    *
    * 思路：
    *   1. 这道题整体思路还是沿用求最大深度的逻辑
    *   2. 但是递归返回值是每个子树的最大深度，而最大直径一定是经过root节点的，所以需要单独声明diameter来保存。
    * */
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = TreeNode.generateTree(arr, 0);
        System.out.println(diameterOfBinaryTree(root));
    }

    // Book's
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        recursiveDepth(root);
        return diameter;
    }

    static int recursiveDepth(TreeNode node) {
        if (node == null) return 0;
        int left = recursiveDepth(node.left);
        int right = recursiveDepth(node.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }


    // An Indian bro's
//    public static int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        int left = diameterOfBinaryTree(root.left);
//        int right = diameterOfBinaryTree(root.right);
//        int diameter3 = recursiveDepth(root.left) + recursiveDepth(root.right);
//        return Math.max(diameter3, Math.max(left, right));
//    }
//
//    static int recursiveDepth(TreeNode node) {
//        if (node == null) return 0;
//        return 1 + Math.max(recursiveDepth(node.left), recursiveDepth(node.right));
//    }
}
