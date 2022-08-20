package com.leetcode.greedy;

import java.util.Arrays;

import static java.lang.System.out;

public class AssignCookies {
    public static void main(String[] args) {
        int[] children = new int[]{1, 2};
        int[] cookies = new int[]{1, 2, 3};
        int result = findContentChildren(children, cookies);

        out.println(result);
    }

    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0, cookie = 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] <= cookies[cookie]) {
                child ++;
            }
            cookie ++;
        }

        return child;
    }
}
