package com.wajahat.backtracking;

import org.junit.Test;

import java.util.Arrays;

/**
 * Find the Knights Tour in 8x8 Chess Board
 * Created by Wajahat
 **/
public class KnightTour {

    void print(int [][] tour, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tour[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean canMove(int [][]tour, int X, int Y, int N) {
        return X >= 0 && X < N && Y >= 0 && Y < N && tour[X][Y] == -1;
    }

    boolean solveUtil(int [][]tour, int N, int movei, int X, int Y, int []dx, int []dy) {
        int i, x, y;
        if (movei == N*N) {
            return true;
        }
        for (i = 0; i < 8; i++) {
            x = X + dx[i];
            y = Y + dy[i];
            if (canMove(tour, x , y, N)) {
                tour[x][y] = movei;
                if (solveUtil(tour, N, movei+1, x , y, dx, dy)) {
                    return true;
                } else {
                    tour[x][y] = -1;
                }
            }
        }
        return false;
    }

    void solve() {
        int N = 8;
        int [][] tour = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(tour[i], -1);
        }

        int []dx = {  2, 1, -1, -2, -2, -1,  1,  2 };
        int []dy = {  1, 2,  2,  1, -1, -2, -2, -1 };
        tour[0][0] = 0;
        if (!solveUtil(tour, N, 1, 0, 0, dx, dy)) {
            System.out.println("solution does not exists");
        } else {
            print(tour, N);
        }
    }

    @Test
    public void testKT() {
        solve();
    }
}
