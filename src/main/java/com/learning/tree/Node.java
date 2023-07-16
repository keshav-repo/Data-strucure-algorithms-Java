package com.learning.tree;

public class Node {
    int data;
    Node right, left;

    int level;
    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public Node(int data, int level) {
        this.data = data;
        this.level = level;
        this.right = null;
        this.left = null;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
