package com.learning.tree;

public class DiameterofTree {

    private static int maxHeight = Integer.MIN_VALUE;

    public static int diameter(Node root) {
        if (root == null) return 0;

        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);

        int curr = height(root.left)+height(root.right)+1;
        return Math.max(curr, Math.max(diameterLeft, diameterRight));
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int ans = diameter(tree.root);
        System.out.println(ans);
    }

}
