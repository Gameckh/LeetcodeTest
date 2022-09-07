package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversalWithoutRecursive {

    /*
    * https://leetcode.com/problems/binary-tree-preorder-traversal/
    *
    * 思路：
    *   1. 题目本身并没有要求不能递归，这里训练一下不使用递归的方案。
    *   2. 递归的本质是栈，所以用栈代替递归实现
    *   3. 注意：栈的顺序是先进后出，所以前序遍历时，需要保证先push右子树
    * */
    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, 3};
        TreeNode root = TreeNode.createTree(arr);
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            int count = stack.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        return res;
    }
}
