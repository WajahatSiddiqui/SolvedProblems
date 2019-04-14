package com.wajahat.interviewbit.hash;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlackCount {
    public boolean canMove(ArrayList<String> A, int N, int M, int i, int j, boolean [][]visited) {
        return i >= 0 && i < N && j >= 0 && j < M && A.get(i).charAt(j) == 'X' && !visited[i][j];
    }

    public void dfs(ArrayList<String> A, int i, int j, int N, int M, boolean [][] visited) {
        visited[i][j] = true;

        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        for (int idx = 0; idx < dx.length; idx++) {
            if (canMove(A, N, M, i + dx[idx], j + dy[idx], visited)) {
                dfs(A, i + dx[idx], j + dy[idx], N, M, visited);
            }
        }


    }
    public int black(ArrayList<String> A) {
        int count = 0;
        int N = A.size();
        int M = A.get(0).length();
        boolean [][]visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(A, i, j, N, M, visited);
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testBlack() {
        ArrayList<String> A = new ArrayList<>();
        A.add("OOOXOOO");
        A.add("OOXXOXO");
        A.add("OXOOOXO");

        assertEquals(3, black(A));

        ArrayList<String> B = new ArrayList<>();
        B.add("XX");
        B.add("XX");

        assertEquals(1, black(B));

        ArrayList<String> C = new ArrayList<>();
        C.add("OO");
        C.add("OO");
        assertEquals(0, black(C));
    }
}
