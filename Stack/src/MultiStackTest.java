import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class Test for MultiStack
 * Created by wajahat
 */
public class MultiStackTest {

    private MultiStack ms;
    public MultiStackTest() {
        ms = new MultiStack(3, 27);

        ms.push(1, 1);
        ms.push(1, 2);
        ms.push(1, 3);
        ms.push(1, 4);
        ms.push(1, 5);

        ms.push(2, 1);
        ms.push(2, 2);
        ms.push(2, 3);
        ms.push(2, 4);
        ms.push(2, 5);

        ms.push(3, 1);
        ms.push(3, 2);
        ms.push(3, 3);
        ms.push(3, 4);
        ms.push(3, 5);
    }

    @Test
    public void testPush() {
        assertEquals(5, ms.size(1));
        assertEquals(5, ms.size(2));
        assertEquals(5, ms.size(3));

        assertEquals(5, ms.peek(1));
        assertEquals(5, ms.peek(2));
        assertEquals(5, ms.peek(3));
    }

    @Test
    public void testPop() {
        assertEquals(5, ms.pop(1));
        assertEquals(4, ms.size(1));
        assertEquals(4, ms.peek(1));

        assertEquals(5, ms.pop(2));
        assertEquals(4, ms.size(2));
        assertEquals(4, ms.peek(2));

        assertEquals(5, ms.pop(3));
        assertEquals(4, ms.size(3));
        assertEquals(4, ms.peek(3));
    }

    @Test
    public void testFull() {
        ms.push(1, 6);
        ms.push(1, 7);
        ms.push(1, 8);
        ms.push(1, 9);

        assertTrue(ms.isFull(1));
    }

    @Test
    public void testEmpty() {
        MultiStack m = new MultiStack(1, 1);
        assertTrue(m.isEmpty(1));
    }
}
