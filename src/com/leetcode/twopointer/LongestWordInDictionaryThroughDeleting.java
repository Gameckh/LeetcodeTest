package com.leetcode.twopointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {

        String s = "abpcplea";
        String[] dictionary = {"ale","apple","monkey","plea"};

        System.out.println(findLongestWord(s, Arrays.asList(dictionary)));
    }

    // 1. 给定一个字符串s和一个字典数组dictionary
    // 2. 找到字典中的某个单词，在删除s中的部分字符后可以得到这个单词
    // 3. 如果没找到，返回空字符串""
    // 4. 如果找到多个，返回最长的
    // 5. 如果找到多个且长度一样，按字典排序，返回最小的那个
    public static String findLongestWord(String s, List<String> dictionary) {

        String longest = "";

        for (String word: dictionary) {
            // word指针
            int wordIndex = 0;
            char[] chars = s.toCharArray();
            // 遍历给定字符串s
            for (char c: chars) {
                // 当word字母没有找完，并且给定s中找到了word的字符时，下一个
                if (wordIndex < word.length() && c == word.charAt(wordIndex)) {
                    wordIndex ++;
                }
                // 不加break，这里无法判断加了break是否更快，因为每次循环都要多一次比较
            }

            // 第一层判断：当word指针等于word长度时，说明s包含word；
            //          word长度大于等于longest时（必须判断等于，因为还要判断满足上述条件5）
            // 第二层判断：先判断是否大于，如果不大于，判断对比字典结果
            if (wordIndex == word.length() && word.length() >= longest.length()) {
                if (word.length() > longest.length() || word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }

        return longest;
    }
}
