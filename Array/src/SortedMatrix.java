import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class Search for an element in sorted matrix
 * Created by wajahat
 */
public class SortedMatrix {

    private boolean search(int [][]arr, int X) {
        int N = arr.length; // rows
        int M = arr[0].length; // cols
        int lo = 0;
        int hi = M-1;
        for (int i = 0; i < N; i++) {
            if (X > arr[i][hi]) {
                continue;
            }
            while (lo < hi) {
                if (arr[i][lo] == X || arr[i][hi] == X) return  true;
                if (X > arr[i][lo]) lo++;
                else
                    hi--;
            }
            lo = 0;
            hi = M-1;
        }
        return false;
    }

    @Test
    public void testSearch() {
        int [][]mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        assertTrue(search(mat, 5));
        assertTrue(search(mat, 1));
        assertTrue(search(mat, 9));
        assertFalse(search(mat, 10));
    }
}
