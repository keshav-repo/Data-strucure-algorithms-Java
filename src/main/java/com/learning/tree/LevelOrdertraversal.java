package com.learning.tree;

public class LevelOrdertraversal {

    static void levelOrder(Node root) {
        int height = HeightOfTree.height(root);
        for(int i=1; i<=height; i++){
            printLevel(root, i);
            System.out.println("");
        }
    }

    private static void printLevel(Node node, int level){
        if(node==null)return;
        if(level==1){
            System.out.print(node.data+" ");
        }else {
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        levelOrder(tree.root);
    }
}
