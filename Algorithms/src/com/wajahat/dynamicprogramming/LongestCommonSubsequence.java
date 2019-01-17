package com.wajahat.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Class Find the LongestCommonSubsequence
 * A sub-sequence is a substring which is not consecutive
 * Created by wajahat
 */
public class LongestCommonSubsequence {

    int findLCS(String str1, String str2) {
        int N = str2.length()+1;
        int M = str1.length()+1;
        int [][]T = new int[N][M];
        // T[0][0] have all zeros

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (str2.charAt(i-1) == str1.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1] + 1;
                } else {
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
                }
            }
        }
        return T[N-1][M-1];
    }

    @Test
    public void testFindLCS() {
        assertEquals(4, findLCS("AGGTAB", "GXTXAYB"));
    }
}
