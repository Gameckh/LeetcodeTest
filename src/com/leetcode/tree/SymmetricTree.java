package com.leetcode.tree;

public class SymmetricTree {

    /*
    * https://leetcode.com/problems/symmetric-tree/
    *
    * 思路：
    *   1. 如果主节点为null，或者两个子树同时为null，true
    *   2. 如果两个子节点一个为空，一个不为空，false
    *   3. 如果两个子树根节点的值不相同，false
    *   4. 根据对称要求，递归，传入需要对比的镜像节点
    * */
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,4,3};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        // 注意，如果走到第二个if，代表两个node一定不同时为空
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        // 注意，玄机在这里。传入的参数里对比的两个节点分别是镜像的节点
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
