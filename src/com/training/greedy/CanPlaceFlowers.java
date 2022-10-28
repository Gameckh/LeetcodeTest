package com.training.greedy;

public class CanPlaceFlowers {


    /*
    * Solution ideas:
    *   Nothing special, just check the position one by one, don't forget put a 1 in the pit which can place a flower.
    *
    * */
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int[] flowerbed1 = {0};
        int[] flowerbed2 = {1,0,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed2, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i-1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                --n;
                if (n == 0) return true;
                flowerbed[i] = 1;
            }
        }
        return false;
    }

}
