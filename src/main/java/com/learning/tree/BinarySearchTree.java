package com.learning.tree;

public class BinarySearchTree {
    private static boolean isBstUtil(Node<Integer> root, Node<Integer> prev) {
        if (root == null) return true;
        boolean leftBst = isBstUtil(root.left, prev);

        if (prev.data >= root.data) {
            return false;
        }
        prev.data = root.data;
        return leftBst && isBstUtil(root.right, prev);
    }

    public static boolean isBst(Node root) {
        Node prev = new Node(Integer.MIN_VALUE);
        return isBstUtil(root, prev);
    }

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(isBst(tree.root));

        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        binaryTree.root = root;

        System.out.println(isBst(binaryTree.root));

        BinaryTree binaryTree2 = new BinaryTree();
        Node root2 = new Node(4);
        root2.left = new Node(3);
        root2.right = new Node(5);
        root2.left.left = new Node(2);
        root2.left.right = new Node(5);
        binaryTree2.root = root2;

        System.out.println(isBst(binaryTree2.root));

    }
}
