package com.training.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*
    * Problem-solving ideas:
    *
    * 1. Use HashMap to save every character's max index.
    * 2. Use two points max & prev, indicates the range of every partition.
    * 3. Travers string again, get the max value between max and char's max index.
    * 4. When max equals the current character's index, that is the partition border.
    * 5. Add max minus i to result list, and assign the current max to prev.
    * */
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int max = 0, prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            max = Math.max(max, map.get(c));
            if (max == i) {
                res.add(max - prev);
                prev = max;
            }
        }

        return res;
    }
}
