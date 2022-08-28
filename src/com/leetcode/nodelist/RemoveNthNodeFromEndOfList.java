package com.leetcode.nodelist;

public class RemoveNthNodeFromEndOfList {

    /*
    * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    *
    * 思路：
    *   不需要遍历两遍，用快慢指针，间隔n步，当快指针为0时，慢指针指向的就是要删除的节点。
    *
    * */
    public static void main(String[] args) {
        int[] a = {1,2};
        int n = 1;
        ListNode head = ListNode.makeListNode(a);
        head = removeNthFromEnd(head, n);
        ListNode.printListNode(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head, slow = head, prev = head;
        while (fast != null) {
            fast = fast.next;
            if (n == 0) {
                prev = slow;
                slow = slow.next;
            } else {
                n--;
            }
        }
        if (slow == head) return head.next;
        prev.next = slow.next;
        return head;
    }
}
