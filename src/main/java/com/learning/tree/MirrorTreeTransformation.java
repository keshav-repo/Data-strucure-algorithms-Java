package com.learning.tree;
public class MirrorTreeTransformation {
    public static Node mirrorTreeUtil(Node root){
        if(root==null) return null;
        mirrorTreeUtil(root.left);
        mirrorTreeUtil(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree<Character> charTree = new BinaryTree();
        charTree.root = new Node('A');
        charTree.root.left = new Node('B');
        charTree.root.right = new Node('C');
        charTree.root.left.left = new Node('D');
        charTree.root.left.right = new Node('E');
        charTree.root.right.left = new Node('F');
        charTree.root.right.right = new Node('G');

        Node root = mirrorTreeUtil(charTree.root);
        InorderTraversal.inorder(root);

    }
}
