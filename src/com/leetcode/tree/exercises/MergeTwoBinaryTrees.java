package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class MergeTwoBinaryTrees {

    /*
    * https://leetcode.com/problems/merge-two-binary-trees/
    * 思路：
    *   1. 判断是否为null，如果其中之一为null，直接返回不为null的即可
    *       ———— 多解释一点，如果有一个为null，不为null的那个无论下边有多少层子节点，只需要保持原状即可；
    *   2. 两个都不为null，创建一个新节点，左右下探即可
    * */
    public static void main(String[] args) {
        Integer[] arr1 = {1,3,2,5};
        Integer[] arr2 = {2,1,3,null,4,null,7};
        TreeNode root1 = TreeNode.createTree(arr1);
        TreeNode root2 = TreeNode.createTree(arr2);
        TreeNode root = mergeTrees(root1, root2);
        TreeNode.preOrderTraverse(root);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
