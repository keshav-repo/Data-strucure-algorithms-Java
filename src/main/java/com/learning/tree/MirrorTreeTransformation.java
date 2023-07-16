package com.learning.tree;
public class MirrorTreeTransformation {
    public Node mirrorTreeUtil(Node root){
        if(root==null) return null;
        mirrorTreeUtil(root.left);
        mirrorTreeUtil(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
