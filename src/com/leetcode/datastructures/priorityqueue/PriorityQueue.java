package com.leetcode.datastructures.priorityqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
*   优先队列（priority queue）可以在 O(1) 时间内获得最大值，并且可以在 O(log n)
时间内取出最大值或插入任意值。
*   优先队列常常用堆（heap）来实现。堆是一个完全二叉树，其每个节点的值总是大于等于子
节点的值。实际实现堆时，我们通常用一个数组而不是用指针建立一个树。这是因为堆是完全二
叉树，所以用数组表示时，位置 i 的节点的父节点位置一定为 (i-1)/2，而它的两个子节点的位置
又一定分别为 2i+1 和 2i+2。
*   以下是堆的实现方法，其中最核心的两个操作是上浮和下沉：如果一个节点比父节点大，那
么需要交换这个两个节点；交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操
作，我们称之为上浮；类似地，如果一个节点比父节小，也需要不断地向下进行比较和交换操作，
我们称之为下沉。如果一个节点有两个子节点，我们总是交换最大的子节点。
* 关于【堆】的更多信息参考：https://www.cnblogs.com/ysocean/p/8032660.html
* */
public class PriorityQueue {

    int[] heap;
    int maxSize;
    int currentSize;
    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        heap = new int[maxSize];
        currentSize = 0;
    }

    // 上浮
    public void swim(int position) {

    }

    // 下沉
    public void sink() {

    }

    // push任意值，新的数字放到最后一位，然后上浮
    public void push() {

    }

    // 删除最大值，把最后一个数字挪到开头，然后下沉
    public void pop() {

    }

    // 获得最大值
    public int top() {
        return heap[0];
    }
}
