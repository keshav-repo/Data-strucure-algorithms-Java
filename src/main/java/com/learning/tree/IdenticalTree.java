package com.learning.tree;

public class IdenticalTree {
    public static boolean checkIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null)
            return (root1.data == root2.data) &&
                    checkIdentical(root1.left, root2.left) &&
                    checkIdentical(root1.right, root2.right);
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        boolean isIdentical = checkIdentical(tree.root, tree.root);
        System.out.println(isIdentical);
    }

}
