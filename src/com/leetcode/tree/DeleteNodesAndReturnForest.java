package com.leetcode.tree;

import java.util.*;

public class DeleteNodesAndReturnForest {

    /*
    * https://leetcode.com/problems/delete-nodes-and-return-forest/
    *
    * 思路：
    *   1. 声明一个Set字典，保存to_delete的值，以便用contains判断是否要删除
    *   2. 后序递归遍历每个节点，当发现要删除的节点时，检查左右节点是否为空
    *   3. 如果左右子节点不为null，可以直接加入forest
    *   4. 记得要把root置为null，并返回root
    * */
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        int[] to_delete = {3,5};
        TreeNode root = TreeNode.createTree(arr);
        List<TreeNode> forest = delNodes(root, to_delete);
        for (TreeNode node : forest) {
            TreeNode.preOrderTraverse(node);
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new LinkedList<>();
        Set<Integer> dict = new HashSet<>();
        for (int delVal: to_delete) {
            dict.add(delVal);
        }
        root = helper(root, dict, forest);
        if (root != null)
            forest.add(root);
        return forest;
    }

    static TreeNode helper(TreeNode root, Set<Integer> dict, List<TreeNode> forest) {
        if (root == null) return null;
        // 注意，这里是后序遍历
        root.left = helper(root.left, dict, forest);
        root.right = helper(root.right, dict, forest);
        // 如果包含了要删除的值，开始执行删除动作
        if (dict.contains(root.val)) {
            // 把左边节点加入forest
            if (root.left != null) {
                forest.add(root.left);
            }
            // 把右边节点加入forest
            if (root.right != null) {
                forest.add(root.right);
            }
            // 给root置空，执行删除
            root = null;
        }
        return root;
    }
}
