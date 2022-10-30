package com.training.sorts.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        if (s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list){
            int times = entry.getValue();
            char c = entry.getKey();
            sb.append(String.valueOf(c).repeat(Math.max(0, times)));
        }

        return sb.toString();
    }
}
