package com.leetcode.tree;

public class TrimABinarySearchTree {

    /*
    * https://leetcode.com/problems/trim-a-binary-search-tree/
    *
    * 思路：
    *   1. 这道题虽然是BST，但是完全不需要中序遍历，只需普通遍历即可
    *   2. 当val高于high时，return trimBST，从左子节点向下继续找（找比当前val小的）
    *   3. 当val低于low时，从右子节点向下继续找（找比当前val大的）
    *   4. 给当前节点的左右子节点赋值，返回当前节点
    * */
    public static void main(String[] args) {
        Integer[] arr = {1,0,2};
        int low = 1, high = 2;
        TreeNode root = TreeNode.createTree(arr);
        trimBST(root, low, high);
        TreeNode.inOderTraverse(root);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static TreeNode trimBST_1(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
