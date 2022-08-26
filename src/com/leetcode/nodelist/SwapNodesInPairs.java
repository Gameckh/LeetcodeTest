package com.leetcode.nodelist;

public class SwapNodesInPairs {

    /*
    * https://leetcode.com/problems/swap-nodes-in-pairs/
    *
    * 思路：
    *   1. 三个指针：
    *       temp -> 主指针，每次循环开始前，指向要交换的两个节点的第一个节点（1234，34）
    *       next -> 原本在后的元素，完成交换后在前（2，4）
    *       prev -> 原本在前的元素，完成交换后在后（1，3）
    *   2. 开始遍历后，遇到next为null时返回head
    *   3. 具体的交换赋值逻辑，建议在纸上画一下
    * */
    public static void main(String[] args) {

        int[] list = {1,2,3,4};
        ListNode head = ListNode.makeListNode(list);
        head = swapPairs(head);
        ListNode.printListNode(head);
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode next = temp.next;
        ListNode prev = null;
        while (temp != null) {
            if (next == null) return head;
            // 把temp的下一个节点移动到第三位，此时要交换的两个指针是temp和next本身
            temp.next = next.next; // temp -> 1,3,4 next -> 2,3,4
            if (prev != null) {
                prev.next = next;
            } else {
                // 当prev为null，也就是第一次交换后，更新head指针
                head = next;
            }
            next.next = temp;
            prev = temp;
            temp = temp.next;
            if (temp != null)
                next = temp.next;
        }
        return head;
    }

}
