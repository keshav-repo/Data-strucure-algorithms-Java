//package com.learning.tree;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class Traversaltest {
//
//    private BinaryTree<Integer> tree;
//    private Traversal traversal;
//
//    public Traversaltest() {
//        tree = new BinaryTree();
//        traversal = new Traversal();
//    }
//
//    @BeforeEach
//    public void init() {
//        tree = getBinaryTree();
//    }
//
//    public BinaryTree getBinaryTree() {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        return tree;
//    }
//
//    @Test
//    public void inorderTest() {
//        traversal.inorder(tree.root);
//    }
//
//    /*
//    *       1
//    *      / \
//    *     2  3
//    *    / \
//    *   4  5
//    * */
//    @Test
//    public void preOrderTest(){
//        traversal.preOrder(tree.root);
//    }
//
//    @Test
//    public void postOrderTest(){
//        traversal.postOrder(tree.root);
//    }
//
//    @Test
//    public void getDepth() {
//        int height = traversal.height(tree.root);
//        assertEquals(3, height);
//    }
//
//    @Test
//    public void checkIdenticalTest() {
//        BinaryTree tree2 = getBinaryTree();
//        assertTrue(traversal.checkIdentical(tree.root, tree2.root));
//    }
//
//    @Test
//    public void isSmmetricalTest() {
//        assertFalse(traversal.isSmmetrical(tree.root));
//        assertTrue(traversal.isSmmetrical(getSymetricalTree().root));
//    }
//
//    @Test
//    public void levelOrderTraversal() {
//        traversal.levelOrderTraversal(tree.root);
//    }
//
//    /*
//      1
//   /   \
//  2     2
// / \   / \
//3   4 4   3
//     */
//    public BinaryTree getSymetricalTree() {
//        BinaryTree binaryTree = new BinaryTree();
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(2);
//        root.left.left = new Node(3);
//        root.left.right = new Node(4);
//        root.right.left = new Node(4);
//        root.right.right = new Node(3);
//        binaryTree.root = root;
//        return binaryTree;
//    }
//
//    @Test
//    public void isBstTest() {
//        assertFalse(traversal.isBst(tree.root));
//
//        BinaryTree binaryTree = new BinaryTree();
//        Node root = new Node(8);
//        root.left = new Node(3);
//        root.right = new Node(10);
//        root.left.left = new Node(2);
//        root.left.right = new Node(5);
//        binaryTree.root = root;
//        assertTrue(traversal.isBst(binaryTree.root));
//
//        BinaryTree binaryTree2 = new BinaryTree();
//        Node root2 = new Node(4);
//        root2.left = new Node(3);
//        root2.right = new Node(5);
//        root2.left.left = new Node(2);
//        root2.left.right = new Node(5);
//        binaryTree2.root = root2;
//        assertFalse(traversal.isBst(binaryTree2.root));
//    }
//
//    @Test
//    public void printBottomViewTest() {
//        BinaryTree binaryTree = getSymetricalTree();
//        traversal.printBottomView(binaryTree.root);
//    }
//
//}
