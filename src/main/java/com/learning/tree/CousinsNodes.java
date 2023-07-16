package com.learning.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CousinsNodes {

    private Map<Integer, List<Integer>> cousions = new HashMap<>();

    public void fetchCousion(Node root) {

        Node left = root.left;
        Node right = root.right;

        fetchCousionUtil(root, root.left, root.right);


        if (right != null && right.left != null) {
            if (!cousions.containsKey(left.data)) {
                cousions.put(left.data, new ArrayList<>(List.of(right.left.data)));
            } else {
                List<Integer> list = cousions.get(left.data);
                list.add(left.data);
                cousions.get(left.data);
            }
        }
        if (right != null && right.right != null) {
            if (cousions.containsKey(left.data)) {
                cousions.put(left.data, new ArrayList<>(List.of(right.right.data)));
            }
        }


    }

    private void fetchCousionUtil(Node root, Node left, Node right) {
        if (left == null || right == null)
            return;
        else {
            List<Integer> leftChildList = childList(left);
            List<Integer> rightChildList = childList(right);

            assignCousing(left, rightChildList);
            assignCousing(right, leftChildList);
        }
    }

    private void assignCousing(Node node, List<Integer> childList) {
        if(node.left!=null){
            cousions.put(node.left.data, childList);
        }
        if(node.right!=null){
            cousions.put(node.right.data, childList);
        }

    }

    private  List<Integer> childList(Node node) {
        List<Integer> list = new ArrayList<>();
        if (node.left != null) {
            list.add(node.left.data);
        }
        if (node.right != null) {
            list.add(node.right.data);
        }
        return list;
    }
}
