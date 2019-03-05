import org.junit.Test;

/**
 * Find Maximum Difference in the Array
 * Created by Wajahat
 **/
public class MaxDifference {

    private int maxDifference(int[] arr) {
        int min_element = arr[0];
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] > min_element) && ((arr[i] - min_element) > diff)) {
                diff = arr[i] - min_element;
            }
            if (arr[i] < min_element) {
                min_element = arr[i];
            }
        }
        return diff < 0 ? -1 : diff;
    }

    @Test
    public void testMaxDifference() {
        int [] arr = {-10, -2, -1, 4, 9, 7};
        System.out.println(maxDifference(arr));
    }
}
