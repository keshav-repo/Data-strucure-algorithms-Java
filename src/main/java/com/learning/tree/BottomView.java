package com.learning.tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomView {
    public static void printBottomView(Node root) {
        // map contains node at a particular x cordinate
        Map<Integer, Node> map = new TreeMap<>();
        printBottomViewUtil(root, 0, 0, map);
        map.forEach((k, v) -> {
            System.out.print(v.data + " ");
        });
    }

    private static void printBottomViewUtil(Node root, int y, int x, Map<Integer, Node> map) {
        if (root == null) return;

        // if level of node existing for x cor is more than prv one, then replace
        if (map.containsKey(x)) {
            Node node = map.get(x);
            if (y > node.level) {
                map.put(x, root);
            }
        } else {
            map.put(x, root);
        }
        printBottomViewUtil(root.left, y + 1, x - 1, map);
        printBottomViewUtil(root.right, y + 1, x + 1, map);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printBottomView(tree.root);
    }
}
