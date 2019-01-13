package com.wajahat.backtracking;

import org.junit.Test;

import java.util.Arrays;

/**
 * Solve Rat in maze problem
 * Created by Wajahat
 **/
public class RatInMaze {

    boolean canMove(int [][] input, int X, int Y, int N) {
        return X >= 0 && Y >= 0 && X < N && Y < N && input[X][Y] == 1;
    }

    void print(int [][] sol, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+ " ");
            }
            System.out.println();
        }
    }

    boolean solveUtil(int [][] input, int [][] sol, int X, int Y, int N) {
        sol[X][Y] = 1;
        if (X == N-1 && Y == N-1) {
            return true;
        } else {
            if (canMove(input, X + 1, Y, N)) {
                return solveUtil(input, sol, X+1, Y, N);
            }

            if (canMove(input, X, Y+1, N)) {
                return solveUtil(input, sol, X, Y+1, N);
            }
        }
        return false;
    }

    void solve(int [][]input, int N) {
        int [][]sol = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(sol[i], 0);

        if (solveUtil(input, sol, 0, 0, N)) {
            print(sol, N);
        } else {
            System.out.println("Solution does not exists");
        }
    }

    @Test
    public void testRatInMaze() {
        int N = 4;
        int [][] input = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        solve(input, N);
    }
}
