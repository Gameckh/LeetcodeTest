package com.leetcode.nodelist;

public class LinkedListCycle {

    /*
    * https://leetcode.com/problems/linked-list-cycle/
    *
    * 思路：
    *   判断循环指针的办法：快慢指针，快指针走两步，慢指针走一步，如果出现循环指针，两个指针会相等。
    *   If it's a little abstract, then let's think about we are running on a circular track.
    *   If the track is 100m long, your speed is 10m/s, your friend's speed is 5m/s.
    * Then after 20s, you've run 200m, your friend has run 100m.
    *   But because the track is circular, so you will be at the same place with your friend
    * since the difference between your distances is exactly 100m.
    * */
    public static void main(String[] args) {

        int[] a = {3,2,0,-4};
        ListNode head = ListNode.makeListNode(a);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
            // 不能放在前边，这样直接就返回true了
            if (fast == head) return true;
        }
        return false;
    }
}
