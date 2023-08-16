package com.learning.tree;

public class HeightBalancedCheck {
    static int isbalanced(Node root) {
        if (root == null)
            return 0;

        int leftHeight = isbalanced(root.left);
        int rightHeight = isbalanced(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
       // root.left.left.left = new Node(8);

        if (isbalanced(root) == -1) {
            System.out.println("Tree is not balanced");
        } else {
            System.out.println("Tree is balanced");
        }
    }
}
