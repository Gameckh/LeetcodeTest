package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    /*
    * https://leetcode.com/problems/binary-tree-postorder-traversal/
    *
    * 思路：
    *   preorder: res.add(root.val); 在递归之前
    *   inorder: res.add(root.val); 在左右递归中间
    *   postorder: res.add(root.val); 在递归之后
    * */
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        recursiveTraversal(root, res);
        return res;
    }

    static void recursiveTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        recursiveTraversal(root.left, res);
        recursiveTraversal(root.right, res);
        res.add(root.val);
    }
}
