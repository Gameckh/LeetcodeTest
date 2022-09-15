package com.leetcode.datastructures.priorityqueue;

import java.util.Arrays;

public class SmallerPriorityQueue {

    // 优先队列（最小值版）

    public static void main(String[] args) {
        SmallerPriorityQueue pq = new SmallerPriorityQueue(12);
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

    public SmallerPriorityQueue(int maxSize) {
        heap = new Integer[maxSize];
        this.maxSize = maxSize;
        currentSize = 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean push(int key) {
        if (isFull()) return false;
        heap[currentSize] = key;
        swim(currentSize);
        currentSize++;
        return true;
    }

    public boolean pop() {
        if (isEmpty()) return false;
        heap[0] = heap[--currentSize];
        sink(0);
        return true;
    }

    private void swap(int from, int to) {
        Integer temp = heap[from];
        heap[from] = heap[to];
        heap[to] = temp;
    }

    // 上浮
    public void swim(int position) {
        while (position > 0 && heap[(position - 1) / 2] > heap[position]) {
            swap((position - 1) / 2, position);
            position = (position - 1) / 2;
        }
    }

    // 下沉
    public void sink(int position) {
        while (position * 2 + 1 <= currentSize) {
            int i = position * 2 + 1;
            if (i < currentSize && heap[i] > heap[i+1]) i++;
            if (heap[position] < heap[i]) break;
            swap(position, i);
            position = i;
        }
    }

    public int top() {
        return heap[0];
    }
}
