package com.wajahat.hackerrank.solution.graph;

import java.util.Scanner;

public class FloydCityOfBindingLights {

    private static int[][] floyd(int [][]graph, int V) {
        int [][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] > 0) {
                    dist[i][j] = graph[i][j];
                } else if (i != j) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 1; k < V; k++) {
            for (int j = 1; j < V; j++) {
                for (int i = 1; i < V; i++) {
                    if (dist[i][k] != Integer.MAX_VALUE
                            && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int [][] graph = new int[N+1][N+1];
            int x, y, r;

            for (int i = 0; i < M; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                r = sc.nextInt();

                graph[x][y] = r;
            }
            int [][]dist = floyd(graph, N+1);
            int q = sc.nextInt();
            int u, v;
            while (q > 0) {
                u = sc.nextInt();
                v = sc.nextInt();

                System.out.println(dist[u][v] == Integer.MAX_VALUE ? -1 : dist[u][v]);
                q--;
            }
        }
    }

}
