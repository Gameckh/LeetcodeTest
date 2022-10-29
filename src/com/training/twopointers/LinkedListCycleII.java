package com.training.twopointers;

import com.leetcode.nodelist.ListNode;

public class LinkedListCycleII {

    /*
    * https://leetcode.com/problems/linked-list-cycle-ii/
    *
    * Problem-solving ideas:
    *
    * This problem has a very interesting comparison as a running contest.
    * If we have two players A and B, A is faster than B, they run along the track endlessly (like a cycle list)
    * Then must have a moment that A catch B.
    * But it's not end where they meet.
    *
    * Floyd Cycle Detection:
    * Set two pointer fast and slow, fast go forward two steps every time and slow go one.
    * When they meet first time, we set fast pointer to head, and let fast point go forward one step every time.
    * When they meet second time, then current node is the beginning of the cycle.
    * */
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        return null;
    }
}
