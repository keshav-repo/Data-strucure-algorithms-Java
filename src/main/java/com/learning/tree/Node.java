package com.learning.tree;

public class Node<T> {
    T data;
    Node right, left;
    int level;
    public Node(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public Node(T data, int level) {
        this.data = data;
        this.level = level;
        this.right = null;
        this.left = null;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
