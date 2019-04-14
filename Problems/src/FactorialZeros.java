import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * FactorialZeros
 *
 * @author wajahat
 */
public class FactorialZeros {

    public int countFactZeros(int num) {
        int count = 0;
        if (num < 0) return -1;
        for (int i = 5; num/i > 0; i *= 5) {
            count += num/i;
        }
        return count;
    }

    @Test
    public void testCountFactZeros() {
        assertEquals(-1, countFactZeros(-1));
        assertEquals(3, countFactZeros(19));
        assertEquals(49, countFactZeros(200));
    }
}
