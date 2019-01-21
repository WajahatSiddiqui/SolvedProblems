package com.wajahat.hackerrank.graph.problems;

import java.util.Stack;

public class Problems {
	
	public void topologicalSort(int [][] graph, int V) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSort(graph, i, V, visited, stack);
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	private void topologicalSort(int [][]graph, int u, int V, boolean[] visited, Stack<Integer> s) {
		visited[u] = true;
		
		for (int v = 0; v < V; v++) {
			if (graph[u][v] == 1 && !visited[v]) {
				topologicalSort(graph, v, V, visited, s);
			}
		}
		s.push(u);
	}

}
