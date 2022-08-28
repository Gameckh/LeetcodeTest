package com.leetcode.nodelist;

public class SortList {

    /*
    * https://leetcode.com/problems/sort-list/
    *
    * 思路：题目要求以 O(nlogn)时间复杂度和O(1)的空间复杂度排序
    * 1. 用快慢指针定位到中点
    * 2. 归并排序
    * */
    public static void main(String[] args) {
        int[] a = {4,2,1,3};
        ListNode head = ListNode.makeListNode(a);
        head = sortList(head);
        ListNode.printListNode(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;

        return head;
    }
}
