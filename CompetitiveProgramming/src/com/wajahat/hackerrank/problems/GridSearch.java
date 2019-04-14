package com.wajahat.hackerrank.problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class GridSearch {

    private static long hash(String [] str) {
        int hash = 5381;
        return 0;
    }

    private static boolean canMove(int r, int c, int R, int C) {
        return r >=  0 && r < R && c >= 0 && c < C;
    }

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, int R, int C, String[] P, int r, int c) {
        long hash_pattern = hash(P);
        int rI = 0, cI = 0;
        String []kernel = new String[r];
        while (canMove(rI, cI, R, C)) {
            kernel[rI] = G[rI].substring(cI, c-1);
            rI++;
            if (rI == r && cI == C && hash(kernel) == hash_pattern) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, R, C, P, r, c);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
