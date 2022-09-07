package com.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class PathSumIII {

    /*
    * https://leetcode.com/problems/path-sum-iii/
    *
    * 思路：
    *   递归每个节点时，需要分情况考虑：
    *    （1）如果选取该节点加入路径，则之后必须继续加入连续节点，或停止加入节点
    *    （2）如果不选取该节点加入路径，则对其左右节点进行重新进行考虑。
    *    （3）需要注意：一旦遇到结果等于targetSum后，需要重新传入targetSum
    *   因此一个方便的方法是我们创建一个辅函数，专门用来计算连续加入节点的路径。
    * */
    public static void main(String[] args) {
        Integer[] arr = {1,-2,-3,1,3,-2,null,-1};
        TreeNode root = TreeNode.createTree(arr);
        int targetSum = 3;
        System.out.println(pathSum(root, targetSum));
    }

    static int result;
    static Set<TreeNode> set = new HashSet<>();
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum, 0L);
        return result;
    }

    static void dfs(TreeNode root, int t, long done) {
        if (root == null) return;
        done += root.val;
        if (done == t) result++;
        dfs(root.left, t, done);
        dfs(root.right, t, done);
        if (!set.contains(root.left)) dfs(root.left, t, 0);
        set.add(root.left);
        if (!set.contains(root.right)) dfs(root.right, t, 0);
        set.add(root.right);
    }
}
