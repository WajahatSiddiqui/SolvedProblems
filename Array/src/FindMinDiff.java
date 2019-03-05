import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * FindMinDiff between two arrays
 *
 * @author wajahat
 */
public class FindMinDiff {
    private int findSmallestDiff(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) return -1;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int a1 = 0, a2 = 0;
        int min = Integer.MAX_VALUE;
        int diff = 0;
        while (a1 < arr1.length && a2 < arr2.length) {
            diff = Math.abs(arr1[a1] - arr2[a2]);
            if (diff < min) {
                min = diff;
            }
            if (arr1[a1] < arr2[a2]) {
                a1++;
            } else {
                a2++;
            }
        }
        return min;
    }

    @Test
    public void testFindSmallestDiff() {
        int [] arr1 = {1, 3, 5, 11, 2};
        int [] arr2 = {23, 127, 235, 19, 8};

        assertEquals(3, findSmallestDiff(arr1, arr2));
    }
}
