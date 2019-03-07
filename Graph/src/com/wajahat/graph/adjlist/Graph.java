package com.wajahat.graph.adjlist;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V, E;
    LinkedList<Integer> adjList[];

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        adjList = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        // for undirected graph
        adjList[v].add(u);
    }

    public boolean isConnected(int u, int v) {
        for (Integer item : adjList[u]) {
            if (item == v) {
                return true;
            }
        }
        return false;
    }

    public void dfs() {
        boolean[] visited = new boolean[V];
        System.out.println("dfs");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
        System.out.println();
    }

    private void dfsUtil(int u, boolean [] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (Integer v : adjList[u]) {
            if (!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    public void bfs() {
        boolean [] visited = new boolean[V];
        System.out.println("bfs");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsUtil(i, visited);
            }
        }
        System.out.println();
    }

    private void bfsUtil(int start, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (Integer v : adjList[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < V; i++) {
            sb.append("Vertex : " + i).append("[");
            for (Integer weight : adjList[i]) {
                sb.append(weight).append(" ");
            }
            sb.append("]").append("\n");
        }
        return sb.toString();
    }
}
