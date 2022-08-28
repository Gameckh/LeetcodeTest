package com.leetcode.nodelist;

public class OddEvenLinkedList {

    /*
    * https://leetcode.com/problems/odd-even-linked-list/
    *
    * 思路：
    * 1. 双指针，odd从1开始，even从2开始
    * 2. 声明两个指针odd和even，代表list的两段，第一个从odd开始，第二个从even开始
    * 3. 循环结束后，把两段list连起来即可
    * */
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode head = oddEvenList(ListNode.makeListNode(a));
        ListNode.printListNode(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        ListNode firstHalf = odd, secondHalf = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = secondHalf;
        return firstHalf;
    }
}
