package com.wajahat.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if (a == null || a.isEmpty()) {
            return 0;
        }

        int N = a.size();
        int M = a.get(0).size();

        for (int i = 0; i < N; i++) {
            if (b <= a.get(i).get(M-1)) {
                return Collections.binarySearch(a.get(i), b) >= 0 ? 1 : 0;
            }
        }
        return 0;
    }

    @Test
    public void testSearchMatrix() {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        a.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        a.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        assertEquals(1, searchMatrix(a, 3));
        assertEquals(1, searchMatrix(a, 34));
        assertEquals(0, searchMatrix(a, 300));

        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<>(Collections.singletonList(1)));
        assertEquals(1, searchMatrix(b, 1));

        assertEquals(0, searchMatrix(null, 1));

        assertEquals(0, searchMatrix(new ArrayList<>(Collections.emptyList()), 1));

        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        c.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2)));
        assertEquals(1, searchMatrix(c, 2));
    }
}
