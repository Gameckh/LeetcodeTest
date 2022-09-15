package com.leetcode.datastructures.priorityqueue;

import java.util.Arrays;

/*
*   优先队列（priority queue）可以在 O(1) 时间内获得最大值，并且可以在 O(log n)
时间内取出最大值或插入任意值。
*   优先队列常常用堆（heap）来实现。堆是一个完全二叉树，其每个节点的值总是大于等于子
节点的值。实际实现堆时，我们通常用一个数组而不是用指针建立一个树。这是因为堆是完全二
叉树，所以用数组表示时，位置 i 的节点的父节点位置一定为 (i-1)/2，而它的两个子节点的位置
又一定分别为 2i+1 和 2i+2。
*
*   以下是堆的实现方法，其中最核心的两个操作是上浮和下沉：如果一个节点比父节点大，那
么需要交换这个两个节点；交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操
作，我们称之为上浮；类似地，如果一个节点比父节小，也需要不断地向下进行比较和交换操作，
我们称之为下沉。如果一个节点有两个子节点，我们总是交换最大的子节点。
*
* 关于【堆】的更多信息参考：https://www.cnblogs.com/ysocean/p/8032660.html
* 首先我们要知道用数组表示堆的一些要点。若数组中节点的索引为index，则：
　　节点的左子节点是 2*index+1，
　　节点的右子节点是 2*index+2，
　　节点的父节点是 （index-1）/2。
　　注意："/" 这个符号，应用于整数的算式时，它执行整除，且得到是是向下取整的值。
* */
public class LargerPriorityQueue {

    public static void main(String[] args) {
        LargerPriorityQueue pq = new LargerPriorityQueue(12);
        pq.push(100);
        pq.push(19);
        pq.push(36);
        pq.push(17);
        pq.push(3);
        pq.push(25);
        pq.push(1);
        pq.push(2);
        pq.push(7);
        pq.push(2);
        pq.push(31);
        pq.push(67);

        System.out.println(Arrays.toString(Arrays.copyOfRange(pq.heap, 0, pq.currentSize)));
        pq.pop();
        System.out.println(Arrays.toString(Arrays.copyOfRange(pq.heap, 0, pq.currentSize)));
        pq.pop();
        System.out.println(Arrays.toString(Arrays.copyOfRange(pq.heap, 0, pq.currentSize)));
        pq.pop();
        System.out.println(Arrays.toString(Arrays.copyOfRange(pq.heap, 0, pq.currentSize)));
        pq.pop();
        System.out.println(Arrays.toString(Arrays.copyOfRange(pq.heap, 0, pq.currentSize)));
    }

    Integer[] heap;
    int maxSize;
    int currentSize;
    public LargerPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        heap = new Integer[maxSize];
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    private void swap(Integer[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // 上浮,把给定position的值上浮到小于parent的位置
    public void swim(int position) {
        while (position > 0 && heap[(position - 1) / 2] < heap[position]) {
            swap(heap, (position - 1) / 2, position);
            position = (position - 1) / 2;
        }
    }

    // 下沉，把root删除，然后把最后一个数字放到root的位置上，再下沉
    public void sink(int position) {
        while(position * 2 + 1 <= currentSize) {
            // 要下沉的节点index
            int i = 2 * position + 1;
            // 判断左边节点是否小于右边节点，以确认是向哪个节点下沉
            if (i < currentSize && heap[i] < heap[i+1]) ++i;
            if (heap[position] > heap[i]) break;
            swap(heap, position, i);
            position = i;
        }
    }

    // push任意值，新的数字放到最后一位，然后上浮
    public void push(int key) {
        if (isFull()) return;
        currentSize++;
        heap[currentSize - 1] = key;
        swim(currentSize - 1);
    }

    // 删除最大值，把最后一个数字挪到开头，然后下沉
    public void pop() {
        if (isEmpty()) return;
        heap[0] = heap[--currentSize];
        sink(0);
    }

    // 获得最大值
    public int top() {
        return heap[0];
    }
}
