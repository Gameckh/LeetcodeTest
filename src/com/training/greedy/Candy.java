package com.training.greedy;

import java.util.Arrays;

public class Candy {

    /*
    *
    * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    * You are giving candies to these children subjected to the following requirements:
    * 1. Each child must have at least one candy.
    * 2. Children with a higher rating get more candies than their neighbors.
    * 3. Return the minimum number of candies you need to have to distribute the candies to the children.
    *
    * Resolve ideal:
    * 1. New an int array for candies count, fill in with ones means every child has one candy at minimum;
    * 2. Traverse the ratings from 1(closure) to length(open), then compare the neighbor ratings, when rating[i] bigger than rating[i-1], plus one candy for rating[i];
    * 3. Traverse the ratings from length-1(closure) to 0(open), then compare the neighbor ratings, when rating[i-1] bigger than rating[i],
    *       give the candies[i-1] the bigger value between candies[i-1] and candies[i]+1.
    *       that because the candies[i-1] already bigger than candies[i]+1 at the first traverse.
    * 4. Return the accumulated value of the candies array.
    * */
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int[] ratings1 = {1,3,2,2,1};
        System.out.println(candy(ratings1));
    }

    public static int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] ++;
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
        }

        return Arrays.stream(candies).sum();
    }
}
