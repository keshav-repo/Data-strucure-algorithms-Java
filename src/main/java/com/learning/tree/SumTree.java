package com.learning.tree;

// Java program to check if Binary tree
// is sum tree or not

import java.util.*;

class SumTree
{
/* A binary tree node has data,
left child and right child */

    static class Node {
        int data;
        Node left, right;

    }

    /* Utility function to check if
    the given node is leaf or not */
    static int isLeaf(Node node)
    {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return 0;
    }

    /* returns data if SumTree property holds for the given
        tree else return -1*/
    static int isSumTree(Node node)
    {
        if(node == null)
            return 0;

        int ls; // for sum of nodes in left subtree
        int rs; // for sum of nodes in right subtree


        ls = isSumTree(node.left);
        if(ls == -1)		 // To stop for further traversal of tree if found not sumTree
            return -1;

        rs = isSumTree(node.right);
        if(rs == -1)		 // To stop for further traversal of tree if found not sumTree
            return -1;


        if(isLeaf(node)==1 || ls + rs == node.data)
            return ls + rs + node.data;
        else
            return -1;

    }

    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers.
    */
    static Node newNode(int data)
    {
        Node node1 = new Node();
        node1.data = data;
        node1.left = null;
        node1.right = null;
        return(node1);
    }

    public static void main(String args[])
    {
        Node root = newNode(26);
        root.left = newNode(10);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(6);
        root.right.right = newNode(3);

        int total = isSumTree(root);
        if(total != -1 && total == 2*(root.data))
            System.out.print("Tree is a Sum Tree");
        else
            System.out.print("Given Tree is not sum Tree");
    }
}
