package com.learning.tree;

public class InorderTraversal {

    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
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

        inorder(tree.root);

        System.out.println("");

        BinaryTree<Character> charTree = new BinaryTree();
        charTree.root = new Node('A');
        charTree.root.left = new Node('B');
        charTree.root.right = new Node('C');
        charTree.root.left.left = new Node('D');
        charTree.root.left.right = new Node('E');
        charTree.root.right.left = new Node('F');
        charTree.root.right.right = new Node('G');

        inorder(charTree.root);
    }
}
