package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /*
    * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    *
    * 思路参考：
    *   com.leetcode.tree.ConstructBinaryTreeFromPreorderAndInorderTraversal
    *   https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/2566604/Java-solution
    * */
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(postorder, inorder);
        TreeNode.preOrderTraverse(root);
    }

    static HashMap<Integer, Integer> inorderIndices = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }
        return recursive(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    static TreeNode recursive(int[] inorder, int[] postorder, int start, int end, int postorderIndex) {
        if (postorderIndex < 0 || postorderIndex >= postorder.length
                || start < 0 || end >= inorder.length || end + 1 - start <= 0) {
            return null;
        }

        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);
        if (start == end) return root;

        int inorderIndex = inorderIndices.get(rootValue);

        int rightSize = end - inorderIndex;
        if (rightSize > 0) {
            root.right = recursive(
                    inorder, postorder, inorderIndex + 1, end, postorderIndex - 1);
        }

        int leftSize = inorderIndex - start;
        if (leftSize > 0) {
            root.left = recursive(
                    inorder, postorder, start, inorderIndex - 1, postorderIndex - 1 - rightSize);
        }

        return root;
    }
}
