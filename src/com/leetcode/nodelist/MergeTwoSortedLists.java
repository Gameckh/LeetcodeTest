package com.leetcode.nodelist;

public class MergeTwoSortedLists {

    /*
    * https://leetcode.com/problems/merge-two-sorted-lists/
    *
    *
    * */
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head, current;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            head = current = list1;
            list1 = list1.next;
        } else {
            head = current = list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current = list1;
                list1 = list1.next;
            } else {
                current = list2;
                list2 = list2.next;
            }
        }

        ListNode tail = list1 == null? list2 : list1;
        while (tail != null) {
            current = tail;
            tail = tail.next;
        }

        return head;
    }
}
