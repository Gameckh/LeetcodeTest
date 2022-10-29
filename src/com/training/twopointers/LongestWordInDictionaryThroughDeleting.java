package com.training.twopointers;

import java.util.*;

public class LongestWordInDictionaryThroughDeleting {

    /*
    * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    *
    * My idea:
    * 1. Two pointer to match the s and words in dictionary.
    * 2. Save the result when match word is found. If not, return an empty string directly.
    * 3. Sort the result by length first and lexicographical second.
    * 4. Return the first word of the result collection.
    *
    * Optimization:
    * 1. Do not use LinkedList or some other collections, just a variable to save the result and set default "";
    * 2. Convert the given s to a char array can increase the execution speed significantly, but will use more space.
    * */
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] d = {"ale","apple","monkey","plea"};
        List<String> dictionary = Arrays.asList(d);
        String result = findLongestWord(s, dictionary);
        System.out.println(result);
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String longest = "";
        for (String word : dictionary) {
            int sp = 0, wp = 0;
            while (sp < s.length() && wp < word.length()) {
                if (s.charAt(sp) == word.charAt(wp)) {
                    wp++;
                }
                sp++;
            }
            if (wp == word.length() && word.length() >= longest.length()) {
                if (word.length() > longest.length() || word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}
