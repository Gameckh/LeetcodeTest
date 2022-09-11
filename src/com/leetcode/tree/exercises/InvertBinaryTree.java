package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class InvertBinaryTree {

    /*
    * https://leetcode.com/problems/invert-binary-tree/
    * 思路：
    *   遍历tree，改变left和right引用
    * */
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.createTree(arr);
        TreeNode.preOrderTraverse(root);
        System.out.println();
        root = invertTree(root);
        TreeNode.preOrderTraverse(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
