package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /*
    * https://leetcode.com/problems/binary-tree-preorder-traversal/
    *
    * 题解：
    *   Preorder Traversal 指的是中 -> 左 -> 右 的遍历顺序，即平时最常见的方式。
    *
    * 思路：
    *   1. 递归 / 非递归，这里用递归
    * */
    public static void main(String[] args) {
        Integer[] root = {1,null,2,3};
        TreeNode node = TreeNode.createTree(root);
        System.out.println(preorderTraversal(node));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return null; // 测试用例要求 root = [] 时，返回[]而不是null
        List<Integer> res = new LinkedList<>();
        recursiveTraversal(root, res);
        return res;
    }

    static void recursiveTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            recursiveTraversal(root.left, res);
            recursiveTraversal(root.right, res);
        }
    }
}
