package com.leetcode.nodelist;

import java.util.List;

public class PalindromeLinkedList {

    /*
    * https://leetcode.com/problems/palindrome-linked-list/
    *
    * 思路：
    * 1. 快慢指针，慢指针一次一步，快指针一次两步；
    * 2. 第一步结束时，慢指针指向中点前1节点，这时reverse剩下的list；
    * 3. 双指针对比，slow.val和head.val一个个比，如果不相等，返回false。
    * */
    public static void main(String[] args) {

        int[] a = {1,2,2,1};
        int[] b = {1,2,3,2,1};
        int[] c = {1,2};

        ListNode head = ListNode.makeListNode(c);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 把slow下一个节点后的list翻转
        slow.next = reverse(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
