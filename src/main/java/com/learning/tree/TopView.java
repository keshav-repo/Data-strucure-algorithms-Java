package com.learning.tree;

// Java program to print top
// view of binary tree
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

// class of binary tree
class TopView {
    Node root;

    public TopView() { root = null; }

    // function should print the topView of
    // the binary tree
    private void TopViewFn(Node root)
    {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap
                = new TreeMap<Integer, Node>();

        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println(
                "The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                        tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                        tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry :
                topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        TopView tree = new TopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.TopViewFn(tree.root);
    }
}
