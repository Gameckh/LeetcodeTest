package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    /*
    * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    *
    * 思路：
    *   0. 由BST的特性可知，要求最小diff，一定是相邻节点之间的差值
    *   1. 中序遍历，每次计算当前节点与上一个节点的diff，拿最小值即可
    *   2. 注意：第一次解题犯了错，不能直接把root和left与right节点算，因为相邻的两个数不一定在left或right上
    * */
    public static void main(String[] args) {
        Integer[] arr = {4,2,6,1,3};
        Integer[] arr1 = {1,0,48,null,null,12,49};
        Integer[] arr2 = {236,104,701,null,227,null,911};
        TreeNode root = TreeNode.createTree(arr2);
        System.out.println(getMinimumDifference(root));
    }

    static int diff = Integer.MAX_VALUE;
    static TreeNode previous;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        getMinimumDifference(root.left);
        if (previous != null)
            diff = Math.min(diff, root.val - previous.val);
        previous = root;
        getMinimumDifference(root.right);
        return diff;
    }
}
