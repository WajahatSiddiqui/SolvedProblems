import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class Rearrange List with first Odd and then Even
 * Created by wajahat
 */
public class RearrangeList {

    // Doing inplace
    // Time Complexity: T(n) = O(n), n is the length of list
    // Space Complexity: S(n) = O(1)
    public List<Integer> rearrange(List<Integer> list) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            // check for odd at the left side
            while (lo < hi && list.get(lo) % 2 != 0) lo++;
            // check for even at the right side
            while (lo < hi && list.get(hi) % 2 == 0) hi--;
            // swap
            if (lo < hi) {
                int tmp = list.get(lo);
                list.set(lo, list.get(hi));
                list.set(hi, tmp);
            }
        }

        return list;
    }

    private long oddCount(List<Integer> list) {
        return list.stream().filter(i->i%2 != 0).count();
    }

    private void check(List<Integer> list) {
        int count = (int) oddCount(list);
        int idx = 0;

        for (Integer i : list) {
            if (idx < count) {
                assertTrue((i & 1) != 0);
                idx++;
            } else {
                assertTrue((i & 1) == 0);
            }
        }
    }

    @Test
    public void testRearrange() {
        // mix values
        check(rearrange(Stream.of(2, 4, 1, 0, 10, 2, 3).collect(Collectors.toList())));
        // all even values
        check(rearrange(Stream.of(2, 4, 0, 10, 2).collect(Collectors.toList())));

        // all odd values
        check(rearrange(Stream.of(3, 1, 9, 7, 5, 17).collect(Collectors.toList())));

        // duplicate values
        check(rearrange(Stream.of(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3).collect(Collectors.toList())));
    }
}
