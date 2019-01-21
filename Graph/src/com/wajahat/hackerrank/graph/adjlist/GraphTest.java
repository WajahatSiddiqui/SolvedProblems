package com.wajahat.hackerrank.graph.adjlist;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GraphTest {
	
	private Graph graph;
	
	public GraphTest() {
		graph = new Graph(5, 7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
	}

	@Test
	public void testAddEdge() {
		assertTrue(graph.isConnected(0, 1));
		assertTrue(graph.isConnected(0, 3));
		assertTrue(graph.isConnected(0, 4));
		assertTrue(graph.isConnected(1, 2));
		assertTrue(graph.isConnected(1, 3));
		assertTrue(graph.isConnected(2, 3));
		assertTrue(graph.isConnected(3, 4));
	}
	
	@Test
	public void testIsConnected() {
		assertTrue(graph.isConnected(2, 3));
		assertTrue(!graph.isConnected(2, 2));
	}

	@Test
	public void testToString() {
		System.out.println("testToString : \n" + graph);
	}
	
	@Test
	public void testdfs() {
		graph.dfs();
	}
	
	@Test
	public void testbfs() {
		graph.bfs();
	}

}
