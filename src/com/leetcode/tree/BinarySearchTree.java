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

    /*
    * 寻找要删除节点的中序后继节点
    * 首先我们引入后继节点的概念，如果将一棵二叉树按照【中序周游】的方式输出，则任一节点的下一个节点就是该节点的后继节点。
    *   之所以强调【中序遍历】，原因在于二叉搜索树一个很重要的特性就是：树中任何结点的左子树中所有结点的值均比该结点小，
    *   右子树中所有结点的值均比该结点大。对二叉搜索树进行中序遍历即得到一个递增排序的序列。
    *   参考：https://www.cnblogs.com/shuaihanhungry/p/5734577.html
    * 分为两种情况：
    *   1.后继节点为待删除节点的右子，只需要将curren用successor替换即可，注意处理好current.left和successor.right.
    *   2.后继节点为待删除结点的右子节点的左子树
    *       算法的步骤是：
    *           successorParent.left=successor.right
    *           successor.left=current.left
    *           parent.left=successor
    * */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        // 判断：如果后继节点为delNode.right的左子节点
        // 1.
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = new Node();
        boolean isRightChild = true;
        while (current.val != key) {
            parent = current;
            if (key > current.val) {
                current = current.right;
                isRightChild = true;
            } else {
                current = current.left;
                isRightChild = false;
            }
            // 没找到key对应的node
            if (current == null) return false;
        }
        // 出了循环，current就是要删除的节点了
        // 判断1：当要删除的节点没有子节点(叶子节点)
        if (current.right == null && current.left == null) {
            if (current == root) {
                root = null;
            } else {
                if (isRightChild) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            }
            return true;
        }
        return false;
    }

}
