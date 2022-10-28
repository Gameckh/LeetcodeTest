package com.training.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    /*
    * LeetCode_406:
    * https://leetcode.com/problems/queue-reconstruction-by-height/
    *
    * Problem-solving idea:
    * https://leetcode.com/problems/queue-reconstruction-by-height/solutions/2211641/visual-explanation-java-greedy/
    *
    * Simple description:
    * People who are higher than others is not care about shorter ones insert between them (ki keep constant)
    * But the shorter people DOES care about higher ones insert between them.
    * So we can solve this problem by next steps:
    * 1. Sort the people by height ascending first, and by Ki ascending second.
    *   Now we get result that higher people at the front of the queue.
    * 2. Travers the people array, and insert the current people to the Ki position.
    *   Higher people will be inserted first, then shorter people.
    *   As we analysed before the higher people don't care the shorter people between them.
    * */
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] current : people) {
            list.add(current[1], current);
        }
        return list.toArray(new int[people.length][]);
    }
}
