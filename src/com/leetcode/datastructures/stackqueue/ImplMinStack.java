package com.leetcode.datastructures.stackqueue;

import java.util.Stack;

public class ImplMinStack {

    /*
    * https://leetcode.com/problems/min-stack/
    *
    * 思路：
    *   1. 用原生stack就可以
    *   2. 需要用另一个stack维护min值，两个思路：
    *       <1> 判断：当push的值小于minStack的peek时，也同时push到minStack中
    *       <2> 不判断：每次push时，直接push一个Math.min(val, minStack.peek())，每次pop时，minStack同时pop即可
    * */
    public static void main(String[] args) {
        /*
        ["MinStack","push","push","push","getMin","pop","getMin"]
        [[],[0],[1],[0],[],[],[]]
        * */
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

    static class MinStack {

        Stack<Integer> stack, minStack;
        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int val) {
            if(minStack.empty())
                minStack.push(val);
            else {
                int min = minStack.peek();
                if (min >= val)
                    minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            int val = stack.peek();
            stack.pop();
            if (!minStack.empty() && minStack.peek() == val)
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
