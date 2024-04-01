package com.learning.tree;

public class GNode<T> {
    T data;
    CNode left, right;
    GNode(T item)
    {
        data = item;
        left = right = null;
    }
}