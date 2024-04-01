package com.learning.graph;

import java.util.Arrays;
import java.util.List;

/*
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
* */
public class ValidTree extends Graph {


    public ValidTree(int v) {
        super(v);
    }

    private boolean isCyclicUtil(int node, int parent, boolean[] visited) {
        visited[node] = true;
        List<Integer> adjNodes = adj[node];
        for (int adjNode : adjNodes) {
            if (adjNode == parent)
                continue;

            if (!visited[adjNode]) {
                if (isCyclicUtil(adjNode, node, visited))
                    return true;
            } else if (adjNode != parent)
                return true;
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[super.v];
        Arrays.fill(visited, false);

        for (int i = 0; i < super.v; i++) {
            if (visited[i] == false) {
                boolean isVisited = isCyclicUtil(i, -1, visited);
                if (isVisited)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
        int n = 5;
        ValidTree validTree = new ValidTree(n);
        validTree.addEdge(0, 1);
        validTree.addEdge(0, 2);
        validTree.addEdge(0, 3);
        validTree.addEdge(1, 4);

        boolean isCyclePresent = validTree.isCyclic();
        validTree.isValidTree(isCyclePresent);

        // n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
        ValidTree validTree2 = new ValidTree(5);
        validTree2.addEdge(0,1);
        validTree2.addEdge(1,2);
        validTree2.addEdge(2, 3);
        validTree2.addEdge(1,3);
        validTree2.addEdge(1,4);
        boolean isCyclePresent2 = validTree2.isCyclic();
        validTree2.isValidTree(isCyclePresent2);
    }

    private void isValidTree(boolean isCyclePresent) {
        if (!isCyclePresent)
            System.out.println("Valid tree");
        else
            System.out.println("Not a valid tree");
    }
}
