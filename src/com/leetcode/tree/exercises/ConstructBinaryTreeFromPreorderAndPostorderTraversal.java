package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /*
    * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
    *
    * */
    public static void main(String[] args) {

    }

    HashMap<Integer, Integer> hashtable = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < preorder.length; i++) {
            hashtable.put(preorder[i], i);
        }
        return recursive(preorder, postorder, 0, preorder.length - 1, postorder.length - 1);
    }

    public TreeNode recursive(int[] preorder, int[] postorder, int start, int end, int postorderIndex) {
        if (start < 0 || end >= preorder.length
                || postorderIndex < 0 || postorderIndex >= postorder.length
                || end + 1 - start <= 0)
            return null;
        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);
        if (start == end) return null;

        int preorderIndex = hashtable.get(rootValue);
        int rightSize = end - preorderIndex;
        int leftSize = preorderIndex - start;
        if (rightSize > 0)
            root.right = recursive(preorder, postorder, preorderIndex + 1, end, postorderIndex - 1);
        if (leftSize > 0)
            root.left = recursive(preorder, postorder, start, preorderIndex - 1, postorderIndex - 1 - rightSize);
        return root;
    }
}
