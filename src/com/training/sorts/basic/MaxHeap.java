package com.training.sorts.basic;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        int[] nums = {15,22,4,71,19,43,53,87,62,10};
        MaxHeap heap = new MaxHeap(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            nums[i] = heap.top();
            heap.pop();
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    * Max heap is a Complete Binary Tree
    * */
    private int maxSize;

    private int size;

    /*
    * Three import formula in max heap:
    * 1. l = p * 2 + 1 [l: left child node index; p: parent node index]
    *    r = p * 2 + 2 [r: right child node index]
    *    notice: This formula works when we count index from zero.
    * 2. p = (n - 1) / 2 [p: parent node index; n: a certain node index]
    * 3. nl = (size-1)/2 [nl: the last non-leaf node]
    * */
    private int[] arr;

    // initialize the heap with a fixed size
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        // from 0 to maxSize
        arr = new int[maxSize];
    }

    // initialize the heap with a given array
    public MaxHeap(int[] nums) {
        this.arr = Arrays.copyOf(nums, nums.length);
        this.maxSize = nums.length;
        this.size = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            this.shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // insert an element to the heap
    public void push(int num) {
        if (size >= maxSize) return;
        arr[size] = num;
        // shift up the num
        this.shiftUp(size);
        size++;
    }

    // delete an element from the heap
    public void pop() {
        if (this.isEmpty()) return;
        swap(0, --size);
        shiftDown(0);
    }

    public int top() {
        return arr[0];
    }

    // swap a big number up to the parent node
    private void shiftUp(int i) {
        // If i more than 0
        // and the parent node less than the i node.
        while( i > 0 && arr[(i-1)/2] < arr[i] ) {
            swap((i-1)/2, i);
            i = (i-1) / 2;
        }
    }

    // swap a small number down to the child node
    private void shiftDown(int i) {
        // Complete Binary Tree:
        // just if it has a left child node, then make the loop continue.
        while ( (i*2+1) < size ) {
            int j = i*2 + 1;
            // Left or Right?
            if ((j + 1) < size && arr[j+1] > arr[j]) {
                j += 1;
            }
            // If i node is already at the right position.
            if (arr[i] >= arr[j]) {
                break;
            }
            // swap them and change i to j.
            swap(i, j);
            i = j;
        }
    }

    private void swap(int x, int y) {
        int temp = this.arr[x];
        this.arr[x] = this.arr[y];
        this.arr[y] = temp;
    }
}
