package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class SumOfLeftLeaves {

    /*
    * https://leetcode.com/problems/sum-of-left-leaves/
    *
    * 思路：
    *   1. 辅助函数，需要加isLeft参数，并且排除root的值
    * */
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(sumOfLeftLeaves(root));
    }

    static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        leftSum(root.left, true);
        leftSum(root.right, false);
        return sum;
    }

    public static void leftSum(TreeNode node, boolean isLeft) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sum += isLeft ? node.val : 0;
        }
        leftSum(node.left, true);
        leftSum(node.right, false);
    }

}
