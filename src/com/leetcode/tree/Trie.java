package com.leetcode.tree;

public class Trie {

    /*
    * https://leetcode.com/problems/implement-trie-prefix-tree/
    *
    * 思路：
    * 1. 声明一个TrieNode类;
    *   1> isWord属性，标记这个node是否是完整word的最后一个字符
    *   2> alphabet属性，是字典树的灵魂，它标记当前字符的字典，是否存在
    * 2. Trie的root为空，这是业界实现字典树的一个传统;
    * 3. insert / search：循环word，找alphabet中是否有当前字符。
    * */
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.alphabet[c - 'a'] == null) {
                current.alphabet[c - 'a'] = new TrieNode();
            }
            current = current.alphabet[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return innerSearch(word, true);
    }

    public boolean startsWith(String prefix) {
        return innerSearch(prefix, false);
    }

    private boolean innerSearch(String word, boolean isSearch) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.alphabet[c - 'a'] == null) return false;
            current = current.alphabet[c - 'a'];
        }
        // isSearch ? current.isWord : true 的简化写法
        return !isSearch || current.isWord;
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] alphabet = new TrieNode[26];
    public TrieNode() {}
}