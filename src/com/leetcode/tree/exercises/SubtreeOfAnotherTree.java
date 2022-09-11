package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class SubtreeOfAnotherTree {

    /*
    * https://leetcode.com/problems/subtree-of-another-tree/
    *
    * 思路：
    *   两个递归
    *   1. isSame：假设已经找到了root和subRoot的相同根节点，判断两个树是否相同
    *   2. isSubtree：负责寻找判断起始节点的，两种情况：
    *       1> 如果isSame返回true，表示已经找到，直接返回即可
    *       2> 如果返回false，有可能是没找到根节点，继续下探root，这里注意两个条件：
    *           a. root遇到null直接返回false，表示压根没找到root
    *           b. 下探时，左右两边是 || 的关系，代表两边任意一边包含子树都算对
    * */
    public static void main(String[] args) {
        Integer[] arrRoot = {3,4,5,1,2};
        Integer[] arrSub = {4,1,2};
        TreeNode root = TreeNode.generateTree(arrRoot, 0);
        TreeNode subRoot = TreeNode.generateTree(arrSub, 0);
        System.out.println(isSubtree(root, subRoot));
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
