package com.leetcode.nodelist;

public class ReverseLinkedList {

    /*
    * https://leetcode.com/problems/reverse-linked-list/
    *
    * 链表操作的基础题，递归和遍历都要掌握：
    *   1. 递归
    *   2. 遍历
    * */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.makeListNode(arr);
        head = reverseListRecursion(head, null);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursion (ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseListRecursion(next, head);
    }
}
