import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

/**
 * Class Implements Queue With Stack
 * Created by wajahat
 */
public class QueueWithStacks {
    private Stack<Integer> recordNew = new Stack<>();
    private Stack<Integer> recordOld = new Stack<>();

    public void enqueue(int data) {
        recordNew.push(data);
    }

    private void shiftStacks() {
        if (recordOld.isEmpty()) {
            while (!recordNew.isEmpty()) {
                recordOld.push(recordNew.pop());
            }
        }
    }

    public int dequeue() {
        if (empty()) throw new RuntimeException("stack is empty");
        shiftStacks();
        return recordOld.pop();
    }

    public int peek() {
        if (empty()) throw new RuntimeException("stack is empty");
        shiftStacks();
        return recordOld.peek();
    }

    public boolean empty() {
        return recordNew.empty() && recordOld.empty();
    }

    public int size() {return recordNew.size() + recordOld.size(); }

    @Test
    public void testMyQueue() {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);

        assertEquals(1, peek());
        assertEquals(1, dequeue());
        assertEquals(2, dequeue());
        assertEquals(3, dequeue());

        enqueue(-1);
        enqueue(15);
        enqueue(100);

        assertEquals(4, dequeue());
        assertEquals(5, dequeue());
        assertEquals(-1, dequeue());
        assertEquals(15, dequeue());
        assertEquals(100, dequeue());

        enqueue(0);
        assertEquals(0, peek());

    }
}
