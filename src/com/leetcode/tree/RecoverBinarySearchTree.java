package com.leetcode.tree;

public class RecoverBinarySearchTree {

    /*
    * https://leetcode.com/problems/recover-binary-search-tree/
    *
    * 思路：
    *   1. 二叉查找树 -> 中序遍历
    *   2. 三个变量，first，second，previous，分别保存第一个错误点，第二个错误点，当前栈root之前的node
    *   3. 两个中序遍历中间的位置，执行：
    *       a. first为空时，遇到prev.val > root.val，给first赋值prev —— 这个if语句只会执行一次，此时first拿到的一定是错误节点之一
    *       b. first不为空时，遇到prev.val > root.val，给second赋值 —— 第一次执行时，first和second是挨着的
    *       c. 把previous的值替换成root，进入下一个inorder
    *   4. 交换first和second的val
    * 参考：
    * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    * 注意，原解法有个地方需要改，当tree里包含MIN_VALUE时，不能用previous.val >= root.val，应该换成 > ，否则过不去case
    * */
    public static void main(String[] args) {
        Integer[] arr = {5,3,9,-2147483648,2};
        TreeNode root = TreeNode.createTree(arr);
        TreeNode.inOderTraverse(root);
        System.out.println();
        recoverTree(root);
        TreeNode.inOderTraverse(root);
    }

    static TreeNode firstNode;
    static TreeNode secondNode;
    static TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);
    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public static void inorderTraverse(TreeNode root) {
        if (root == null) return;
        // 中序遍历
        inorderTraverse(root.left);
        // 在这里判断
        if (firstNode == null && previousNode.val > root.val) {
            firstNode = previousNode;
        }
        if (firstNode != null && previousNode.val > root.val) {
            secondNode = root;
        }
        previousNode = root;
        inorderTraverse(root.right);
    }

    private static void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstNode == null && previousNode.val > root.val) {
            firstNode = previousNode;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstNode != null && previousNode.val > root.val) {
            secondNode = root;
        }
        previousNode = root;

        // End of "do some business"
        traverse(root.right);
    }
}
