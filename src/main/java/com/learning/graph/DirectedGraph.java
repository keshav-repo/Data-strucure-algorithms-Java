package com.learning.graph;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
    int v;
    List<Integer> adj[];
    public DirectedGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<this.v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int initNode, int finalNode){
        adj[initNode].add(finalNode);
    }
}
