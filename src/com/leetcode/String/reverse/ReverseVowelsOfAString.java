package com.leetcode.String.reverse;

public class ReverseVowelsOfAString {


    /*
    * https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/
    *
    * 加了条件的ReverseString
    * 注意元音大小写
    * */
    public static void main(String[] args) {

        String s = "aA";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;
        while( i < j ) {
            if(!isVowel(chars[i])) {
                i++;
                continue;
            }
            if(!isVowel(chars[j])) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
        return new String(chars);
    }

    public static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
