package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class ConvertBSTToGreaterTree {

    /*
    * https://leetcode.com/problems/convert-bst-to-greater-tree/
    *
    * 思路：
    *   分析题目，有两个信息点：
    *   1. BST：首先考虑中序遍历
    *   2. Greater Tree的定义，小数节点的值 = 所有大于它节点的值的累加
    *   由此：
    *   1. 中序遍历
    *   2. 逆序，先遍历right，中间部分直接累加，更新val的值，然后再left
    * */
    public static void main(String[] args) {
        Integer[] arr = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = TreeNode.createTree(arr);
        convertBST(root);
        TreeNode.inOderTraverse(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        sum(root);
        return root;
    }

    static int sum = 0;
    public static void sum(TreeNode current) {
        if (current == null) return;
        sum(current.right);
        current.val += sum;
        sum = current.val;
        sum(current.left);
    }
}
