package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    /*
    * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    *
    * 思路：
    *   利用BST的性质：左小右大
    *   遍历树，判断当前节点的val是否比两个节点大 / 小，找到满足 min <= node <= max即可
    * */
    public static void main(String[] args) {
        Integer[] arr = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.createTree(arr);
        int p = 2, q = 8;
        TreeNode pNode = search(root, p);
        TreeNode qNode = search(root, q);
        System.out.println(lowestCommonAncestor(root, pNode, qNode));
    }

    static TreeNode search(TreeNode root, int target) {
        if (root == null)
            return null;
        if (root.val < target)
            return search(root.right, target);
        if (root.val > target)
            return search(root.left, target);
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int big = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val < small) {
                root = root.right;
            } else if (root.val > big) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}
