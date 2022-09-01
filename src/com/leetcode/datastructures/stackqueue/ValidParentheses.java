package com.leetcode.datastructures.stackqueue;

import java.util.Stack;

public class ValidParentheses {

    /*
    * https://leetcode.com/problems/valid-parentheses/
    *   Parentheses /pəˈren.θə.siːz/ brackets 圆括号
    *   Square brackets 方括号
    *   Curly/ˈkɜː.li/ brackets 花括号
    * */
    public static void main(String[] args) {

        String s = "((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if (s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            switch (bracket){
                case '(':
                case '[':
                case '{':
                    stack.push(bracket);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty()) return false;
                    char top = stack.peek();
                    if (top == '(' && bracket == ')' ||
                            top == '[' && bracket == ']' ||
                            top == '{' && bracket == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}
