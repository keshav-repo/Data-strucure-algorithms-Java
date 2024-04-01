package com.learning.tree;

public class DiameterofTree {

    private static int maxHeight = Integer.MIN_VALUE;

    public static int diameter(Node root) {
        if (root == null) return 0;

        int heightLeft = diameter(root.left);
        int heightRight = diameter(root.right);

        maxHeight = Math.max(maxHeight, 1 + heightLeft + heightRight);

        return 1 + Math.max(heightLeft, heightRight);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        diameter(tree.root);
        System.out.println(maxHeight);
    }

}
