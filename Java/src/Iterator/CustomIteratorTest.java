package Iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class Test for custom iterator
 * Created by wajahat
 */
public class CustomIteratorTest {

    private CustomIterator<Integer> customIterator;
    private List<Iterator<Integer>> list = new ArrayList<>(2);

    public CustomIteratorTest() {
        list.add(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()).iterator());
        list.add(Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList()).iterator());

        customIterator = new CustomIterator<>(list);
    }

    @Test
    public void testNext() {
        int i = 1;
        while (customIterator.hasNext()) {
            assertEquals(i++, customIterator.next().intValue());
        }
        assertEquals(11, i);
    }
}
