import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Class Find Duplicates using runner technique
 * Given Array from 1 to n numbers in the list  find if it has duplicates
 * Created by wajahat
 */
public class FindDuplicates {

    int isDuplicate(int []arr) {
        if (arr.length <= 1) return -1;
        int slow = arr[0];
        int fast = arr[arr[0]];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    @Test
    public void testIsDuplicate() {
        int [] arr1 = {1, 2, 3, 4, 2};
        assertEquals(2, isDuplicate(arr1));

        int [] arr2 = {1};
        assertEquals(-1, isDuplicate(arr2));
    }
}
