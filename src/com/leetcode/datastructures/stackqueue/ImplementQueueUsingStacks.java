package com.leetcode.datastructures.stackqueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /*
    * https://leetcode.com/problems/implement-queue-using-stacks/
    *
    * 思路：
    *   1. 用两个Stack实现一个queue
    *   2. 原理实际上是利用了stack后进先出的规则，两个stack需要来回导数据
    *
    Test case:
    Input
    ["MyQueue", "push", "push", "peek", "pop", "empty"]
    [[], [1], [2], [], [], []]
    Output
    [null, null, null, 1, 1, false]

    Explanation
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek(); // return 1
    myQueue.pop(); // return 1, queue is [2]
    myQueue.empty(); // return false
    * */
    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

    static class MyQueue {

        Stack<Integer> in, out;
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            int x = out.peek();
            out.pop();
            return x;
        }

        void in2out() {
            if (out.empty()) {
                while (!in.empty()) {
                    int x = in.peek();
                    in.pop();
                    out.push(x);
                }
            }
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }
}
