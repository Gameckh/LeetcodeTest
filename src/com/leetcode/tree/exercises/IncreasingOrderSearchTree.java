package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class IncreasingOrderSearchTree {

    /*
    * https://leetcode.com/problems/increasing-order-search-tree/
    *
    * 思路：
    *   1. 理解题目：原来是BST，转化后按preOrder遍历结果是递增的
    *   2. 中序遍历：声明两个变量分别保存开始节点、上一个节点
    *   3. 关键步骤：当为prev.right赋值root前(或后)，一定要清空root.left，不然会循环递归
    * */
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode root = TreeNode.createTree(arr);
        root = increasingBST(root);
        TreeNode.preOrderTraverse(root);
    }

    static TreeNode start;
    static TreeNode prev;
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        if (prev != null) {
            // Key step: 如果不把root.left清空，会导致循环
            root.left = null;
            prev.right = root;
        }
        if (start == null) start = root;
        prev = root;
        increasingBST(root.right);
        return start;
    }
}
