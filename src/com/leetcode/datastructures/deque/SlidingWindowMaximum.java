package com.leetcode.datastructures.deque;

import java.util.*;

public class SlidingWindowMaximum {

    /*
    * https://leetcode.com/problems/sliding-window-maximum/
    *
    * */
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindow_3(nums, k);
    }

    // Stack -> Accepted
    public static int[] maxSlidingWindow_3(int[] arr, int k) {
        // For Finding Next Greater Element
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; --i) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()])
                st.pop();
            if (st.isEmpty()) nge[i] = arr.length;
            else nge[i] = st.peek();
            st.push(i);
        }

        int[] ans = new int[arr.length - k + 1];
        int j = 0; // To travel in nge
        for (int i = 0; i <= arr.length - k; ++i) {
            if (j < i) j = i;
            while (nge[j] < i + k) j = nge[j];
            ans[i] = arr[j];
        }
        return ans;
    }

    // PriorityQueue -> Time Limit Exceeded
    public static int[] maxSlidingWindow_2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        list.add(pq.peek());
        pq.remove(nums[0]);

        for (int i = k; i < nums.length; i++) {
            pq.offer(nums[i]);
            list.add(pq.peek());
            pq.remove(nums[i - k + 1]);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // Deque -> Time Limit Exceeded
    public static int[] maxSlidingWindow_1(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // ???????????? i - k == 0????????????i == k???????????????????????????k + 1?????????
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }
            // ????????????????????????i??????????????????????????????????????????
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // ????????????????????????????????????????????????????????????
            if (i >= k - 1) {
                list.add(nums[deque.peek()]);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
