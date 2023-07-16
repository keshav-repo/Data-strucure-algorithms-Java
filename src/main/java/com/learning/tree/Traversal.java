package com.learning.tree;



import java.util.Map;
import java.util.TreeMap;

public class Traversal {

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public int height(Node root) {
        if (root == null)
            return 0;
        else {
            int leftD = height(root.left);
            int rightD = height(root.right);
            return leftD > rightD ? (leftD + 1) : (rightD + 1);
        }
    }

    public boolean checkIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null)
            return (root1.data == root2.data) &&
                    checkIdentical(root1.left, root2.left) &&
                    checkIdentical(root1.right, root2.right);
        return false;
    }

    public boolean isSmmetrical(Node root) {
        return isMirror(root, root);
    }

    private boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null)
            return (root1.data == root2.data) &&
                    isMirror(root1.left, root2.right) &&
                    isMirror(root1.right, root2.left);
        return false;
    }

    public void levelOrderTraversal(Node root) {
        int h = height(root);
        for (int height = 1; height <= h; height++) {
            printLevel(root, height);
        }
    }

    private void printLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.out.print(node.data + " ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    // check bst
    public boolean isBst(Node root) {
        Node prev = new Node(Integer.MIN_VALUE);
        return isBstUtil(root, prev);
    }

    private boolean isBstUtil(Node root, Node prev) {
        if (root == null) return true;
        boolean leftBst = isBstUtil(root.left, prev);

        if (prev.data >= root.data) {
            return false;
        }
        prev.data = root.data;
        return leftBst && isBstUtil(root.right, prev);
    }

    public void printBottomView(Node root) {
        // map contains node at a particular x cordinate
        Map<Integer, Node> map = new TreeMap<>();
        printBottomViewUtil(root, 0, 0, map);
        map.forEach((k, v) -> {
            System.out.print(v.data + " ");
        });
    }

    private void printBottomViewUtil(Node root, int y, int x, Map<Integer, Node> map) {
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
}
