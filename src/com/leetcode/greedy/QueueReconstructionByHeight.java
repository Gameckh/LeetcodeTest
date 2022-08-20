package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {

        int[][] people = new int[][]{ new int[]{7,0}, new int[]{4,4}, new int[]{7,1}, new int[]{5,0}, new int[]{6,1}, new int[]{5,2}};

//        System.out.println(Arrays.toString(new int[2]));
        System.out.println(Arrays.deepToString(reconstructQueue(people)));

    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
