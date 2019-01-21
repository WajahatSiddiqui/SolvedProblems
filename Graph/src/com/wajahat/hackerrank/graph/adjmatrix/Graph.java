package com.wajahat.hackerrank.graph.adjmatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Graph {
	
	int V, E;
	int [][] adjMatrix;
	
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		adjMatrix = new int[V][V];
	}
	
	public void setAdjMatrix(int [][]mat) {
		if (mat.length != V && mat[0].length != V) {
			throw new IllegalArgumentException("Invalid adj matrix");
		}
		for (int i = 0; i < V; i++) {
			adjMatrix[i] = Arrays.copyOf(mat[i], V);
		}
	}
	
	public boolean isConnected(int u, int v) {
		return adjMatrix[u][v] == 1;
	}
	
	public void dfs() {
		boolean [] visited = new boolean[V];
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
		for (int v = 0; v < V; v++) {
			if (adjMatrix[u][v] == 1 && !visited[v])
				dfsUtil(v, visited);
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
			for (int v = 0; v < V; v++) {
				if (adjMatrix[u][v] == 1 && !visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i < V; i++) {
			sb.append("{");
			for (int j = 0; j < V; j++) {
				sb.append(adjMatrix[i][j]).append(" ");	
			}
			sb.append("}");
			if (i < V-1) sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}

}
