package com.wajahat.graph.problems;

import org.junit.Test;

public class ProblemsTest {

	int [][]adjMat = {{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{1, 1, 0, 0, 0, 0},
			{1, 0, 1, 0, 0, 0}};
	
	private Problems problems;
	
	public ProblemsTest() {
		problems = new Problems();
	}

	@Test
	public void testTopologicalSort() {
		problems.topologicalSort(adjMat, 6);
	}

}
