package com.leetcode.greedy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int n = 1;
        int[] flowerbed= new int[]{0,1,0,1,0,1,0,0};
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        int size = flowerbed.length;
        int flowerCount = 0;

        if (size == 1 && flowerbed[0] == 0) {
            flowerCount = 1;
            return n <= flowerCount;
        }

        boolean prev = false;
        for (int i = 0; i < size; i++ ) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                flowerCount ++;
                prev = true;
                continue;
            }
            if ((i+1) == size) {
                if (flowerbed[i] == 0 && !prev) {
                    flowerCount ++;
                }
                continue;
            }
            if (flowerbed[i] == 0 && flowerbed[i+1] == 0 && !prev) {
                flowerCount ++;
                prev = true;
            } else {
                prev = flowerbed[i] != 0;
            }
        }

        return n <= flowerCount;
    }
}
