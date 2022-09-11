package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

import java.util.HashSet;

public class TwoSumIVInputIsABST {

    /*
    * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    *
    * 思路，两种解法：
    *   一、利用BST的search方法：BST专用，时间和空间复杂度都相对更优一些
    *       1. 利用BST的特性，search方法来定位k - root.val
    *       2. 特殊的地方在于：
    *           <1> 每找一个节点，都要search一下，而且要确保把剩余的元素都search到，所以不能简单地在当前节点进行下钻
    *           <2> 不能重复计算root节点，比如[1],2 这个test case，容易搞错
    *       3. 逻辑如下：
    *           <1> 声明两个辅助函数，dfs负责深度遍历树节点，search负责查找diff是否存在
    *           <2> 对应的，两个函数各维护自己的node，dfs和search不冲突
    *           <3> 注意search返回true的判断，不仅 root.val == diff，而且要满足 root != current，不能自己加自己
    *   二、利用哈希表：二叉树通用
    *       1. 声明hashset，声明辅助函数dfs
    *       2. dfs按正常的深度优先遍历，每次判断一下set中是否contains k-root.val
    *       3. 继续dfs，left and right即可
    * */
    public static void main(String[] args) {
        Integer[] arr = {2,1,3};
        Integer[] arr1 = {1};
        TreeNode root = TreeNode.createTree(arr);
        int k = 4;
        System.out.println(findTarget_hash(root, k));
    }

    public static boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    static boolean dfs (TreeNode root, TreeNode current, int k) {
        if (current == null) return false;
        boolean isFound = search(root, current, k - current.val);
        if (isFound) return true;
        return dfs(root, current.left, k) || dfs(root, current.right, k);
    }

    static boolean search(TreeNode root, TreeNode current, int diff){
        if (root == null) return false;
        if (root.val == diff && root != current) return true;
        if (root.val > diff)
            return search(root.left, current, diff);
        else
            return search(root.right, current, diff);
    }

    public static boolean findTarget_hash(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs_hash(root, set, k);
    }
    static boolean dfs_hash(TreeNode root, HashSet<Integer> set, int k){
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs_hash(root.left, set, k) || dfs_hash(root.right, set, k);
    }
}
