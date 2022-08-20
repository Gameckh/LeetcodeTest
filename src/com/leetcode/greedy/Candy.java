package com.leetcode.greedy;

import java.util.Arrays;

import static java.lang.System.out;

public class Candy {

    public static void main(String[] args) {

        int[] ratings = new int[]{1,0,2};
        out.println(candy(ratings));

    }

    public static int candy(int[] ratings) {

        int size = ratings.length;
        if ( size < 2 ){
            return size;
        }

        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);

        for ( int i = 1; i < size; i++ ) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }

        for ( int i = size - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                num [i-1] = Math.max( num[i-1], num[i] + 1 );
            }
        }

        return Arrays.stream(num).sum();
    }
}
