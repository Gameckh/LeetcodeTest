package com.leetcode.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 以宽度优先遍历数组来初始化binary tree
    // 有bug，{1, null, 2, 3}的case过不来
    public static TreeNode generateTree(Integer[] root, int start) {
        TreeNode node = null;
        if (root == null || root.length == 0 || root[start] == null) return node;
        node = new TreeNode(root[start]);

        int lNode = start*2 + 1;
        int rNode = start*2 + 2;

        // 左节点
        if (lNode > root.length - 1) {
          node.left = null;
        } else {
          node.left = generateTree(root, lNode);
        }

        // 右节点
        if (rNode > root.length - 1) {
          node.right = null;
        } else {
          node.right = generateTree(root, rNode);
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,2,3,4,5,null,6,null,null,7,8};
        TreeNode treeNode = generateTree(root, 0);
        preOrderTraverse(treeNode);
    }

    // 先序深度优先遍历 -> 中、左、右
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

}
