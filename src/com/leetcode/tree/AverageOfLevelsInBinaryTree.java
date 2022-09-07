package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    /*
    * https://leetcode.com/problems/average-of-levels-in-binary-tree/
    *
    * 思路：经典的广度遍历树，值得写10遍
    *   1. 声明一个Queue，先把root加进来
    *   2. While循环，当queue不为空的时候一直循环
    *   3. while里先拿queue的size，作为每一层的节点数
    *   4. 内循环遍历当前层的所有node，每遍历一次，queue弹出一个node，sum累加一个val
    *   5. 然后判断左右节点是否为空，不为空直接加进来就可以，count结束后自动进入下一层
    * */
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(arr);
        List<Double> averages = averageOfLevels(root);
        System.out.println(averages);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();
        if (root == null) return averages;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 每次外层循环，代表遍历完了一层
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            // 注意，这个count代表了每一层的元素个数
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.peek();
                queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            averages.add(sum / count);
        }
        return averages;
    }
}
