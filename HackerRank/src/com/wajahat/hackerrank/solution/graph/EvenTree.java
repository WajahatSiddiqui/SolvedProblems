package com.wajahat.hackerrank.solution.graph;

import java.util.Arrays;
import java.util.Scanner;

public class EvenTree {

	private static int dfs(int [][]adjMat, int root, int start, int V) {
		boolean [] dfsvisited = new boolean[V];
		Arrays.fill(dfsvisited, false);
		return dfsUtil(adjMat, dfsvisited, root, start, V, 1);
	}

	private static int dfsUtil(int [][]adjMat, boolean [] visited, int root, int u, int V, int count) {
		visited[u] = true;

		for (int v = 1; v < V; v++) {
			if (v != root && adjMat[u][v] == 1 && !visited[v]) {
				count = dfsUtil(adjMat, visited, root, v, V, count+1);
			}
		}
		return count;
	}

	private static int countEvenTree(int [][]adjMat, int N) {
		int count = 0;
		boolean [] visited = new boolean[N+1];
		// run dfs from root to count the subtree nodes
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (!visited[j] && i != j && adjMat[i][j] == 1 && dfs(adjMat, i, j, N+1) % 2 == 0) {
					count++;
				}
			}
			visited[i] = true;
		}
		return count;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// root starting from 1
			int [][]adjMat = new int[N+1][N+1];

			int u, v;

			for (int i = 0; i < M; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				adjMat[u][v] = 1;
				adjMat[v][u] = 1;
			}

			System.out.println(countEvenTree(adjMat, N));
		}
	}

}
