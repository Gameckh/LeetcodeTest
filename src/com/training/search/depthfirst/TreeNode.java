package com.training.search.depthfirst;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.valueOf(this.val);
    }

    // 利用广度优先遍历（队列）的方式生成二叉树
    // 可以跑通{1, null, 2, 3}的case
    public static TreeNode createTree(Integer[] arr) {
        // 使用队列来存储每一层的非空节点，下一层的数目要比上一层高
        ArrayDeque<TreeNode> pre = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        pre.addLast(root);
        // 表示要遍历的下一个节点
        int index = 0;
        while (!pre.isEmpty()) {

            ArrayDeque<TreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.removeFirst();
                TreeNode left=null;
                TreeNode right=null;
                // 如果对应索引上的数组不为空的话就创建一个节点,进行判断的时候，
                // 要先索引看是否已经超过数组的长度，如果索引已经超过了数组的长度，那么剩下节点的左右子节点就都是空了
                // 这里index每次都会增加，实际上是不必要的，但是这样写比较简单
                if (++index<arr.length&&arr[index]!=null){
                    left=new TreeNode(arr[index]);
                    cur.addLast(left);
                }
                if (++index<arr.length&&arr[index]!=null){
                    right=new TreeNode(arr[index]);
                    cur.addLast(right);
                }
                node.left=left;
                node.right=right;
            }
            pre=cur;
        }
        return root;
    }

    // 以宽度优先遍历数组来初始化binary tree
    // 有bug，{1, null, 2, 3}的case过不来
    public static TreeNode generateTree(Integer[] root, int start) {
        TreeNode node = null;
        if (root == null || root.length == 0 || root[start] == null) return node;
        node = new TreeNode(root[start]);

        int lNode = start*2 + 1;
        int rNode = start*2 + 2;

        // 左节点
        if (lNode > root.length - 1) {
          node.left = null;
        } else {
          node.left = generateTree(root, lNode);
        }

        // 右节点
        if (rNode > root.length - 1) {
          node.right = null;
        } else {
          node.right = generateTree(root, rNode);
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1, null, 2, 3};
        TreeNode treeNode = createTree(root);
//        preOrderTraverse(treeNode);
        breathFirstSearch(treeNode);
    }

    // 先序深度优先遍历 -> 中、左、右
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void inOderTraverse(TreeNode root) {
        if (root != null) {
            inOderTraverse(root.left);
            System.out.print(root.val + ", ");
            inOderTraverse(root.right);
        }
    }

    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.println(root.val);
        }
    }

    public static void breathFirstSearch(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
    }

}
