package com.learning.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort extends DirectedGraph {
    public TopologicalSort(int v) {
        super(v);
    }

    void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[super.v];
        Arrays.fill(visited, false);

        for (int i=0; i<super.v; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+", ");
        }
    }

    private void topologicalSortUtil(int currNode, boolean[] visited, Stack<Integer> stack) {
        visited[currNode] = true;
        List<Integer> adjNodes = super.adj[currNode];

        for (int adjNode: adjNodes){
            if(!visited[adjNode])
                topologicalSortUtil(adjNode, visited,stack);
        }
        stack.push(currNode);
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}
