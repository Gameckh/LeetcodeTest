package com.leetcode.tree;

/*
* 二叉查找树 BST 的实现：
*
*   Java 版本参考：https://www.cnblogs.com/yahuian/p/java-binary-search-tree.html
*
* */
public class BinarySearchTree {

    private class Node {
        int val;
        Node left;
        Node right;
    }

    private Node root;

    public BinarySearchTree() {

    }

    public void insert(int key) {

        Node node = new Node();
        node.val = key;

        if (root == null) {
            root = node;
        } else {
            Node parent;
            Node current = root;
            while (true) {
                // 保存parent值，下面用current进行下探
                parent = current;
                if (key > current.val) {
                    // 大于，向右转
                    current = current.right;
                    // 找到空位了，给parent.right赋值即可
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    // 注意，这里没有做 == 处理，实际上等于的都会放到左边，按先后顺序
                    // 小于，向左转
                    current = current.left;
                    // 同理，找到空位，赋值即可
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                }
            }
        }
    }

    public void preOrder(Node root)
    { // 前序遍历,"中左右"
        if (root != null)
        {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root)
    { // 中序遍历,"左中右"
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root)
    { // 后序遍历,"左右中"
        if (root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static final int PRE_ORDER = 1;
    public static final int IN_ORDER = 2;
    public static final int POST_ORDER = 3;
    public void traverse(int traverseType)
    {    // 选择以何种方式遍历
        switch (traverseType)
        {
            case 1:
                System.out.print("preOrder traversal ");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("inOrder traversal ");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("postOrder traversal ");
                postOrder(root);
                System.out.println();
                break;
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.val != key) {
            if (key > current.val)
                current = current.right;
            else
                current = current.left;
            if (current == null) return null;
        }
        return current;
    }

    public int getNodeVal(Node node) {
        return node.val;
    }



}
