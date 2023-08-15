package com.learning.tree;

public class HeightOfTree {
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
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int ans = height(tree.root);
        System.out.println(ans);

        BinaryTree<Character> charTree = new BinaryTree();
        charTree.root = new Node('A');
        charTree.root.left = new Node('B');
        charTree.root.right = new Node('C');
        charTree.root.left.left = new Node('D');
        charTree.root.left.right = new Node('E');
        charTree.root.right.left = new Node('F');
        charTree.root.right.right = new Node('G');

        int ans2 = height(charTree.root);
        System.out.println(ans2);
    }
}
