package com.leetcode.tree.exercises;

import com.leetcode.datastructures.priorityqueue.ListNode;
import com.leetcode.tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    /*
    * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    *
    * 思路：
    *   1. 这个题目中实际上要求转成平衡二叉搜索树（height-balanced binary search tree）
    *   2.
    * */
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        ListNode head = ListNode.makeListNode(arr);
        TreeNode root = sortedListToBST(head);
        TreeNode.preOrderTraverse(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return null;
    }
}
