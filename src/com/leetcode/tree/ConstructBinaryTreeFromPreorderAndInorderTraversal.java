package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /*
    * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    *
    * 思路：
    *   这道题有个重要前提：
    *       preorder and inorder consist of unique values.
    *   这道题核心的逻辑在于：
    *       1. 找到前序数组中对应的元素，在中序数组中对应的位置
    *       2. 中序数组中对应元素的左边是左子树，右边是右子树
    *   流程：
    *       1. 声明一个HashMap，便于查找位置；声明一个index，便于查找preorder的元素
    *       2. 给辅助函数声明两个坐标，start和end
    *       3. 从preorder中按顺序取数，此时取出的每一个元素，都看作是一个中间节点（root节点）
    *       4. 创建TreeNode，并从hashtable中获取到这个元素在inorder的位置
    *       5. 递归找left, right，left从start到position-1，right从position+1到end
    * */
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.preOrderTraverse(root);
    }

    static Map<Integer, Integer> hashtable = new HashMap<>();
    static int index = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // prepare the hashtable
        for (int i = 0; i < inorder.length; i++) {
            hashtable.put(inorder[i], i);
        }
        return recursiveSolve(preorder, inorder, 0, inorder.length - 1);
    }

    static TreeNode recursiveSolve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end || end >= inorder.length) return null;
        int element = preorder[index];
        index++;
        TreeNode node = new TreeNode(element);
        int position = hashtable.get(element);
        node.left = recursiveSolve(preorder, inorder, start, position - 1);
        node.right = recursiveSolve(preorder, inorder, position + 1, end);
        return node;
    }

}
