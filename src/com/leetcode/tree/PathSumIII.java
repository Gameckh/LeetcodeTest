package com.leetcode.tree;

public class PathSumIII {

    /*
    * https://leetcode.com/problems/path-sum-iii/
    *
    * 思路：
    *   递归每个节点时，需要分情况考虑：
    *    （1）如果选取该节点加入路径，则之后必须继续加入连续节点，或停止加入节点
    *    （2）如果不选取该节点加入路径，则对其左右节点进行重新进行考虑。
    *   因此一个方便的方法是我们创建一个辅函数，专门用来计算连续加入节点的路径。
    * */
    public static void main(String[] args) {
        Integer[] arr = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNode.createTree(arr);
        int targetSum = 8;
        System.out.println(pathSum(root, targetSum));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 从root 开始，每一个节点都要计算路径
        long rootSum = pathSumStartWithRoot(root, targetSum);
        long leftSum = pathSumStartWithRoot(root.left, targetSum);
        long rightSum = pathSumStartWithRoot(root.right, targetSum);
        return (int)(rootSum + leftSum + rightSum);
    }

    static long pathSumStartWithRoot(TreeNode root, long targetSum) {
        if (root == null) return 0;
        // 如果结果等于targetSum，count + 1;
        long count = root.val == targetSum? 1 : 0;
        // 继续这条线，从子节点计算路径（0或负值）
        count += pathSumStartWithRoot(root.left, targetSum - root.val);
        count += pathSumStartWithRoot(root.right, targetSum - root.val);
        return count;
    }
}
