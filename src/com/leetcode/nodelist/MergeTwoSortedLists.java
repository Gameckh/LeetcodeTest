package com.leetcode.nodelist;

public class MergeTwoSortedLists {

    /*
    * https://leetcode.com/problems/merge-two-sorted-lists/
    *
    * 思路：两个解法，循环和递归
    *   1. 循环：
    *       <1> 声明起始节点head（避免为null先初始化一个node），当前节点current
    *       <2> 当两个节点都不为null时，list1.val小就把current.next指向list1，反之亦然
    *       <3> 无论current.next最后指到list1还是list2，要把current引用更新到current.next
    *       <4> 当list1\2其中之一为null时，直接把current.next直到非null的节点上就完事了
    *       <5> 切记最后返回的是head.next，因为开始时刚好初始化了一个节点。
    *   2. 递归：
    *       <1> 递归结束flag：list1 == null 和 list2 == null
    *       <2> 每次递归需要判断大小，list2大就从list1.next继续，并返回list1，反之亦然
    * */
    public static void main(String[] args) {
        int[] l1 = {1,2,4}, l2 = {1,3,4};
        ListNode list1 = ListNode.makeListNode(l1);
        ListNode list2 = ListNode.makeListNode(l2);
        ListNode res = mergeTwoLists(list1, list2);
        ListNode.printListNode(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0), current = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null? list2 : list1;

        return head.next;
    }

    public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }
        list1.next = mergeTwoListsRecursion(list1.next, list2);
        return list1;
    }
}
