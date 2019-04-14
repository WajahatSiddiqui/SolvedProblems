package com.wajahat.graph.problems;

import org.junit.Test;

public class ProblemsTest {

    int [][]adjMat1 = {{0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0}};

    int [][]adjMat2 = {{0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0}};
    
    private Problems problems;
    
    public ProblemsTest() {
        problems = new Problems();
    }

    @Test
    public void testTopologicalSort() {
        problems.topologicalSort(adjMat1, 6);
    }

    @Test
    public void testBuildOrder() {
        problems.topologicalSort(adjMat2, 6);
    }

}
