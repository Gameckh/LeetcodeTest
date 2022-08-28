package com.leetcode.nodelist;

public class RemoveDuplicatesFromSortedList {

    /*
    *
    *
    * */
    public static void main(String[] args) {

//        int[] a = {1,1,2,3,3};
//        int[] a = {1,1,2};
        int[] a = {1,1,1,1,1};
        ListNode head = deleteDuplicates(ListNode.makeListNode(a));
        ListNode.printListNode(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode next, dummy = head;
        while (head != null) {
            next = head.next;
            if (next != null && head.val == next.val) {
                head.next = next.next;
            } else
                head = head.next;
        }
        return dummy;
    }
}
