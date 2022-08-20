package com.leetcode.sorts;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {

        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));
    }
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c: chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> frequencies = new ArrayList<>(map.entrySet());
        frequencies.sort((o1, o2) -> o2.getValue() - o1.getValue());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: frequencies) {
            int frequency = entry.getValue();
            char c = entry.getKey();
            result.append(String.valueOf(c).repeat(Math.max(0, frequency)));
        }

        return result.toString();
    }
}
