package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class DeleteNodeInBST_2 {

    /*
    * 这个解法参考leetcode:
    *   https://leetcode.com/problems/delete-node-in-a-bst/discuss/2544365/Java-Simple-Solution-or-RunTime%3A-faster-than-100
    *
    * 思路：
    *   1.
    * */
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,7};
        TreeNode root = TreeNode.createTree(arr);
        TreeNode.preOrderTraverse(root);
        root = deleteNode(root, 3);
        System.out.println();
        TreeNode.preOrderTraverse(root);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null || root.right == null){
                if (root.left != null)
                    return root.left;
                return root.right;
            }
            // 如果有两个子节点:
            // 从root的右节点开始找左子节点的值，返回结果是后继节点的值
            int num = minimumNode(root.right);
            root.val = num;
            root.right = deleteNode(root.right, num);
        }
        return root;
    }

    // 寻找successor
    public static int minimumNode(TreeNode root) {
        int minimum = Integer.MAX_VALUE;
        while (root != null) {
            minimum = Math.min(minimum, root.val);
            root = root.left;
        }
        return minimum;
    }
}
