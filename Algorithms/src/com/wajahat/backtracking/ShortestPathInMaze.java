package com.wajahat.backtracking;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Find the shortest path between source and destination of a given maze
 * Created by Wajahat
 **/
public class ShortestPathInMaze {

    static class point {
        int x, y, dist;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = 0;
        }

        public point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof point)) return false;
            point p = (point) obj;
            return p.x == x && p.y == y;
        }
    }

    boolean canMove(int [][] input, int N, int M, int X, int Y) {
        return X >= 0 && X < N && Y >= 0 && Y < M && input[X][Y] == 1;
    }

    int solveUtil(int [][] input, int N, int M, point src, point destn) {
        int count = 0;
        Queue<point> queue = new ArrayDeque<>();
        queue.add(src);
        input[src.x][src.y] = 0;
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};
        int x, y;
        while (!queue.isEmpty()) {
            point front = queue.poll();
            if (front == null) throw new RuntimeException("invalid queue");
            if (front.equals(destn)) {
                return front.dist;
            }
            for (int i = 0; i < 4; i++) {
                x = front.x + dx[i];
                y = front.y + dy[i];
                if (canMove(input, N, M, x, y)) {
                    input[x][y] = 0;
                    count++;
                    queue.add(new point(x, y, front.dist+1));
                }
            }
        }
        return -1;
    }

    int solve(int [][]input, int N, int M, point src, point destn) {
        return solveUtil(input, N, M, src, destn);
    }

    @Test
    public void testShortestPath() {
        int N = 9, M = 10;
        int [][]mat  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        assertEquals(11, solve(mat, N, M, new point(0, 0), new point(3, 4)));
    }
}
