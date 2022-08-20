package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        Map<Character, LetterStatistics> charStatistics = characterLetterStatistics(s);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            LetterStatistics ls = charStatistics.get(c);
            if (ls.getCount() == 1) {
                result.add(1);
                continue;
            }
            int endIndex = ls.getEndIndex();
            for (int j = i; j < endIndex; j++) {
                char innerC = s.charAt(j);
                LetterStatistics innerLs = charStatistics.get(innerC);
                if (innerLs.getEndIndex() > endIndex) {
                    endIndex = innerLs.getEndIndex();
                }
            }
            result.add(endIndex - ls.getStartIndex() + 1);
            i = endIndex;
        }

        return result;
    }

    private static Map<Character, LetterStatistics> characterLetterStatistics(String s) {
        Map<Character, LetterStatistics> charStatistics = new HashMap<>();

        char[] charArr = s.toCharArray();
        int charArrLen = charArr.length;

        for (int i = 0; i < charArrLen; i++) {
            char c = charArr[i];
            LetterStatistics ls = charStatistics.get(c);
            if (ls == null) {
                ls = new LetterStatistics( 1, i, i);
                charStatistics.put(c, ls);
                continue;
            }
            ls.setCount(ls.getCount() + 1);
            ls.setEndIndex(i);
        }

        return charStatistics;
    }

    static class LetterStatistics {

        public LetterStatistics (
                int count,
                int startIndex,
                int endIndex
        ) {
            this.count = count;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        private int count;
        private int startIndex;
        private int endIndex;

        public int getCount() {
            return count;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }
    }
}
