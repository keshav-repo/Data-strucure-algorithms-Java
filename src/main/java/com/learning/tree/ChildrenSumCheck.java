package com.learning.tree;

public class ChildrenSumCheck {

    static boolean checkChildrenSum(Node<Integer> root) {

//        Node<Integer> leftN = root.left;
//        Node<Integer> rightN = root.right;
//
//        checkChildrenSum(leftN);
//        checkChildrenSum(rightN);

        if (root == null) return true;

        if(root.left==null && root.right==null)
            return true;

        int left = root.left == null ? 0 : (int) root.left.data;
        int right = root.right == null ? 0 : (int) root.right.data;

        return (root.data == (left + right)) &&
                checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node<Integer>(10);
        tree.root.left = new Node<Integer>(8);
        tree.root.right = new Node<Integer>(2);
        tree.root.left.left = new Node<Integer>(3);
        tree.root.left.right = new Node<Integer>(5);
        tree.root.right.right = new Node<Integer>(2);

        if (checkChildrenSum(tree.root)) {
            System.out.println("The given tree satisfies children sum property");
        } else {
            System.out.println("The given tree does not satisfies children sum property");
        }
    }
}
