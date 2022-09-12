package com.leetcode.tree.exercises;

import com.leetcode.tree.TreeNode;

public class DeleteNodeInABST {

    /*
    * https://leetcode.com/problems/delete-node-in-a-bst/
    *
    * 思路：https://www.cnblogs.com/yahuian/p/java-binary-search-tree.html
    *   要实现一个BST，最麻烦的就是delete，需要分三种情况讨论
    *   1. 要删除的节点是叶子节点（left,right = null）：直接把父节点的引用设置为null即可
    *   2. 要删除的节点只有一个子树：给父节点的left/right直接赋值子节点的引用即可
    *   3. 要删除的节点有两个子树时，引入successor的概念，同时分两种情况讨论
    *       <0> successor：中序遍历BST，任意节点的下一个节点就是它的successor
    *       <1> successor为del_node的right：把del_node删掉后，用successor代替del_node即可
    *       <2> successor为del_node的right_node的left：
    *               a. successorParent: del_node的right_node
    *                   successorParent.left = successor.right
    *               b. successor.left = del_node.left
    *               c. parent: del_node的父节点
    *                   parent.left = successor
    * */
    /*
     * 寻找要删除节点的中序后继节点
     * 首先我们引入后继节点的概念，如果将一棵二叉树按照【中序周游】的方式输出，则任一节点的下一个节点就是该节点的后继节点。
     *   之所以强调【中序遍历】，原因在于二叉搜索树一个很重要的特性就是：树中任何结点的左子树中所有结点的值均比该结点小，
     *   右子树中所有结点的值均比该结点大。对二叉搜索树进行中序遍历即得到一个递增排序的序列。
     *   参考：https://www.cnblogs.com/shuaihanhungry/p/5734577.html
     * 分为两种情况：
     *   1.后继节点为待删除节点的右子节点，只需要将curren用successor替换即可，注意处理好current.left和successor.right.
     *   2.后继节点为待删除结点的右子节点的左子树
     *       算法的步骤是：
     *           successorParent.left=successor.right
     *           successor.left=current.left
     *           parent.left=successor
     * */
    public static void main(String[] args) {

    }

    public TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        // successor 一定在delNode的右侧，具体是右子节点还是右子树，下方判断
        TreeNode current = delNode.right;

        // while执行完后，就可以拿到successor
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        // 判断：如果后继节点为delNode.right的左子节点
        // 1. successor的右子节点，移动到successorParent的左子节点上
        // 2. successor的右子节点，拿到删除节点的右子节点
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode current = root;
        TreeNode parent = new TreeNode();
        boolean isRightChild = true;
        // 这个while循环可以记下来，就是在BST中查找一个具体的值
        while (current.val != key) {
            parent = current;
            if (current.val > key) {
                current = current.left;
                isRightChild = false;
            } else {
                current = current.right;
                isRightChild = true;
            }
            if (current == null) return null;
        }
        // 出了循环，current就是delNode了
        /*
        * 以下判断分三步走，具体思路参考以上详细分析
        * */
        // 判断1：当要删除的节点没有子节点时（叶子节点）
        if (current.left == null && current.right == null) {
            // 如果要删除的delNode就是root，直接删掉，返回null
            if (current == root) return null;
            if (isRightChild) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            return root;
        }
        // 判断2：当要删除的节点只有一个节点时
        if (current.left == null || current.right == null) {
            if (isRightChild) {
                parent.right = current.right;
            } else {
                parent.left = current.left;
            }
            return root;
        }
        // 判断3：两个节点，分左右讨论，先获取successor
        TreeNode successor = getSuccessor(current);
        if (current == root) return successor;
        if (isRightChild) {
            current.right = successor;
        } else {
            current.left = successor;
        }
        successor.left = current.left;
        return root;
    }
}
