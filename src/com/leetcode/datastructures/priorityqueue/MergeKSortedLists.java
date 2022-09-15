package com.leetcode.datastructures.priorityqueue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /*
    * https://leetcode.com/problems/merge-k-sorted-lists/
    *
    * 思路：
    *   这道题可以用归并排序两两合并，但更好的办法是用优先队列（更快）
    *   参考答案：
    * https://leetcode.com/problems/merge-k-sorted-lists/discuss/2572634/priority-queue-oror-Java-oror-Merging-one-by-one
    * */
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode result = new ListNode(0);

        for (ListNode list : lists) {
            while (list != null) {
                pq.offer(list);
                list = list.next;
            }
        }

        if (pq.isEmpty()) return null;

        ListNode current = result;
        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
            current.next = null;
        }

        return result.next;
    }
}
