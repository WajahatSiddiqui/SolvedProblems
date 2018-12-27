package com.wajahat.graph.adjmatrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GraphTest {

	private Graph graph;
	private int[][]adjMat = {{0, 1, 0, 1, 1},
			{1, 0, 1, 1, 0},
			{0, 1, 0, 1, 0},
			{1, 1, 1, 0, 1},
			{1, 0, 0, 1, 0}};

	public GraphTest() {
		graph = new Graph(5, 7);
		graph.setAdjMatrix(adjMat);
	}

	@Test
	public void testSetAdjMatrix() {
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
