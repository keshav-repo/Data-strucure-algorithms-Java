package com.learning.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTransformationTest {

    private BinaryTree tree;
    private MirrorTreeTransformation transformation;

    private Traversal traversal;

    public TreeTransformationTest() {
        tree = new BinaryTree();
        transformation = new MirrorTreeTransformation();
        traversal = new Traversal();
    }

    @BeforeEach
    public void init() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
    }

    @Test
    public void mirrorTreeUtilTest() {
        Node root = transformation.mirrorTreeUtil(tree.root);
        traversal.inorder(root);
    }

}
