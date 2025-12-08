package com.wajahat.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirected {

    private static List<Integer> findShortestPathBFS(List<List<Integer>> graph, int start, int end, int V) {
        int[] parent = new int[V];
        int[] distance = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(parent, -1);
        Arrays.fill(distance, Integer.MAX_VALUE);

        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (distance[neighbor] == Integer.MAX_VALUE) {
                    distance[neighbor] = distance[node] + 1;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int currentNode = end;
        while (currentNode != -1) {
            path.add(currentNode);
            currentNode = parent[currentNode];
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String args[]) {
        int V = 8;
        int E = 10;

        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(0, 3),
                Arrays.asList(3, 4),
                Arrays.asList(3, 7),
                Arrays.asList(4, 5),
                Arrays.asList(4, 6),
                Arrays.asList(4, 7),
                Arrays.asList(6, 7),
                Arrays.asList(5, 6)
        );

        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        List<Integer> shortestPath = findShortestPathBFS(graph, 0, 7, V);
        System.out.println("Shortest path from 0 to 7: " + shortestPath);
    }
}