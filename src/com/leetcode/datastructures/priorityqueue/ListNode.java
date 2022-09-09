package com.leetcode.datastructures.priorityqueue;

public class ListNode {

    /*
    * LeetCode上的链表是给定的一个特殊的数据结构，所以需要在本地能够生成它
    * 大体功能是：
    *   1. 传入一个数组，生成对应的NodeList的header
    * */

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode makeListNode(int[] arr) {
        if (arr == null) return null;
        ListNode head = new ListNode();
        if (arr.length == 0) return head;
        ListNode current = head;
        for (int i = 0; i < arr.length; i++) {
            current.val = arr[i];
            // 当遇到最后一个元素时，不再创建next
            if (i < arr.length - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = makeListNode(arr);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
