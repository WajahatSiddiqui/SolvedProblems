package com.wajahat.solution.graph;

import java.util.Scanner;

public class RoadsInHackerLand {
	
	private static int[][] dijkstra(int [][]graph, int V) {
		int [][] dist = new int[V][V];
		
		for (int i = 1; i < V; i++) {
			for (int j = i+1; j < V; j++) {
				if (graph[i][j] > 0) {
					dist[i][j] = graph[i][j];
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int [][]graph = new int[N+1][N+1];
			
			int x, y, r;
			for (int i = 0; i < M; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				r = sc.nextInt();
				
				graph[x][y] = (int) Math.pow(2, r);
			}
			int [][] dist = dijkstra(graph, N+1);
			
			int sum = 0;
			for (int i = 1; i < N+1; i++) {
				for (int j = i+1; j < N+1; j++) {
					if (dist[i][j] != Integer.MAX_VALUE) {
						sum += dist[i][j];
					}
				}
			}
			
			System.out.println(Integer.valueOf(sum + "", 2));
		}
	}

}
