package com.wajahat.search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Binary search obviously works on searching for elements in a sorted array. But if you think about the reason why it works is because the array itself is monotonic ( either increasing or decreasing ). So, if you are a particular position, you can make a definite call whether the answer lies in the left part of the position or the right part of it.
 *
 * Similar thing can be done with monotonic functions ( monotonically increasing or decreasing ) as well.
 * Lets say we have f(x) which increases when x increases.
 *
 * So, given a problem of finding x so that f(x) = p, I can do a binary search for x.
 *
 * At any instance,
 * 1. if f(current_position) > p, then I will search for values lower than current_position.
 * 2. if f(current_position) < p, then I will search for values higher than current_position
 * 3. if f(current_position) = p, then I have found my answer.
 */

public class BinarySearch {

    int binarySearch(Integer []A, int k) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = A.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            if (k == A[mid])
                return mid;
            else if (k < A[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    int binarySearch(Integer [] A, int lo, int hi, int k) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;
        if (k == A[mid])
            return mid;

        else if (k < A[mid])
            return binarySearch(A, lo, mid - 1, k);
        else
            return binarySearch(A, mid + 1, hi, k);
    }


    @Test
    public void testBinarySearch() {
        assertEquals(2, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 3));
        assertEquals(1, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 2));
        assertEquals(3, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]),  4));
        assertEquals(-1, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 10));

        assertEquals(2, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 0, 4, 3));
        assertEquals(1, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 0, 4, 2));
        assertEquals(3, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 0, 4, 4));
        assertEquals(-1, binarySearch(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[5]), 0, 4, 10));
    }
}
