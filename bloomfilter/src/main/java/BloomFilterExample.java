import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * BloomFilterExample
 *
 * @author wajahat
 */
public class BloomFilterExample {

    public BloomFilter<Integer> create(int value, double probability) {
        return BloomFilter.create(Funnels.integerFunnel(),
                value,
                probability);
    }

    @Test
    public void testCreate1() {
        BloomFilter<Integer> filter = create(5, 0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);

        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));

        assertFalse(filter.mightContain(4));
    }

    @Test
    public void testCreate2() {
        BloomFilter<Integer> filter = create(5, 0.01);

        IntStream.range(0, 100_000).forEach(filter::put);

        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));

        // this too returns true which isnt should be ?
        assertTrue(filter.mightContain(1_000_000));
    }

}

