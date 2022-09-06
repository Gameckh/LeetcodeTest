package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /*
    * https://leetcode.com/problems/binary-tree-inorder-traversal/
    *
    * 思路：
    *   与preorder类似，把add val放到中间即可。
    * */
    public static void main(String[] args) {
        Integer[] root = {1,null,2,3};
        TreeNode node = TreeNode.createTree(root);
        TreeNode.inOderTraverse(node);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        recursiveTraversal(root, res);
        return res;
    }

    static void recursiveTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        recursiveTraversal(root.left, res);
        res.add(root.val);
        recursiveTraversal(root.right, res);
    }
}
