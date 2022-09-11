package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    /*
    * https://leetcode.com/problems/find-bottom-left-tree-value/
    *
    * 思路：
    *   1. 广度优先遍历：涉及到层级，深度优先需要维护level
    *   2. 每一层队列逆序遍历，这样当q为空，退出while循环时，拿到的就是结果
    * */
    public static void main(String[] args) {
        Integer[] arr1 = {1, null, 1};
        Integer[] arr2 = {1,2,3,4,null,5,6,null,null,7,null,8};
        TreeNode root = TreeNode.createTree(arr2);
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null)
                q.add(root.right);
            if (root.left != null)
                q.add(root.left);
        }
        return root.val;
    }
}
