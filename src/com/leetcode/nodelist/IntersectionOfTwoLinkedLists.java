package com.leetcode.nodelist;

public class IntersectionOfTwoLinkedLists {

    /*
    * https://leetcode.com/problems/intersection-of-two-linked-lists/
    *
    * 思路：
    *   本题的解体思路相当牛逼：
    *   设headA到相交点的距离为a，headB到相交点的距离为b，相交点到终点的距离为c
    *   可以得到：同时移动两个指针，到相交点的步数为：a + b + c
    *   1. 声明两个指针，分别指向headA和headB
    *   2. 两个指针同时next，如果遇到next为null时，跳到对面的起点（headB, headA）
    *   3. 当两个指针相等时，就是相交点；
    *   4. 如果没有相交点，两个指针走完两个链表后，结果都是null，也可以结束遍历。
    * */
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6,7};
        ListNode headA = ListNode.makeListNode(a);
        ListNode headB = ListNode.makeListNode(b);
        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
    }
}
