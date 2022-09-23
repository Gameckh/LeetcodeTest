package com.leetcode.datastructures.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    /*
    * https://leetcode.com/problems/implement-stack-using-queues/
    *
    * 思路：
    *   1. 原题目没有限制queue的数量，但下方鼓励用1个queue
    *   2. 在push新元素的时候，把除了peek位置以外的所有元素重新推一遍queue即可
    * */
    public static void main(String[] args) {

    }

}

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int i = queue.size();
        while(i-- > 1) {
            queue.offer(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

