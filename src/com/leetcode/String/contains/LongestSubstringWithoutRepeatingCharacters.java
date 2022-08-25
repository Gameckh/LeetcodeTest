package com.leetcode.String.contains;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    /*
    * https://leetcode.com/problems/longest-substring-without-repeating-characters/
    *
    *
    * */
    public static void main(String[] args) {
        String s = "a a";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (n == 0) return 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int cur = i;
            Set<Character> set = new HashSet<>();
            while (cur < n && !set.contains(s.charAt(cur))) {
                set.add(s.charAt(cur++));
            }
            maxLen = Math.max(maxLen, cur - i);
            set.clear();
        }

        return maxLen;
    }

    // faster
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if (n==0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0, j=0; i<n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
