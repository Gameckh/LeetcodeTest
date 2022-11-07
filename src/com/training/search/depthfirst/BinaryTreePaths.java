package com.training.search.depthfirst;

import java.util.*;

public class BinaryTreePaths {

    /*
    * https://leetcode.com/problems/binary-tree-paths/
    * */
    public static void main(String[] args) {
        Integer[] rootArr = {1,2,3,null,5};
        TreeNode root = TreeNode.createTree(rootArr);
        System.out.println(binaryTreePaths(root));
    }

    /*
    * This Problem can also use backtracking,
    * */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private static void dfs(TreeNode node, List<String> res, String path) {
        if (node == null) return;
        path += node.val + "->";
        if (node.left == null && node.right == null) {
            res.add(path.substring(0, path.length()-2));
            return;
        }
        dfs(node.left, res, path);
        dfs(node.right, res, path);
    }
}
