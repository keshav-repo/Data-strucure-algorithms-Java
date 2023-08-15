package com.learning.tree;

public class IsSymmetrical {

    private static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null)
            return (root1.data == root2.data) &&
                    isMirror(root1.left, root2.right) &&
                    isMirror(root1.right, root2.left);
        return false;
    }
    public static boolean isSmmetrical(Node root) {
        return isMirror(root, root);
    }

        /*
      1
   /   \
  2     2
 / \   / \
3   4 4   3
     */
    public static BinaryTree getSymetricalTree() {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        binaryTree.root = root;
        return binaryTree;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = getSymetricalTree();
        boolean symetricTrue = isSmmetrical(binaryTree.root);
        System.out.println(symetricTrue);
    }
}
