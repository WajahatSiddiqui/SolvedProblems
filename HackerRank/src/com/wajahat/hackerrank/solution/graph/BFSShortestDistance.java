package com.wajahat.hackerrank.solution.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestDistance {

	private static final int DISTANCE = 6;

	private static void bfs(int [][]graph, int V, int u, boolean []visited, int [] distance) {
		visited[u] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(u);

		while (!queue.isEmpty()) {
			int front = queue.poll();
			for (int i = 1; i < V; i++) {
				if (graph[front][i] != 0 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					distance[i] = distance[front] + graph[front][i];
				}
			}
		}
	}

	private static void printShortestDistance(int [][]graph, int n, int start) {
		boolean []visited = new boolean[n+1];
		int [] distance = new int[n+1];
		Arrays.fill(visited, false);
		Arrays.fill(distance, 0);

		bfs(graph, n+1, start, visited, distance);

		for (int i = 1; i < n+1; i++) {
			if (i != start && visited[i]) {
				System.out.print(distance[i] + " ");
			} else if (!visited[i]) {
				System.out.print(-1 + " ");
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt(); // queries

			while (q > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();

				int [][]graph = new int[n+1][n+1];

				for (int i = 0; i < m; i++) {
					int u = sc.nextInt();
					int v = sc.nextInt();
					graph[u][v] = DISTANCE;
					graph[v][u] = DISTANCE;
				}

				int start = sc.nextInt();

				printShortestDistance(graph, n, start);
				System.out.println();
				q--;
			}
		}

	}

}
