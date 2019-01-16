import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Class Implementation of Blocking Queue
 * Created by wajahat
 */
public class BlockingQueue<T> {

    private final Queue<T> queue;
    int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>(capacity);
    }

    public void add(T element) {
        synchronized (queue) {
            while (queue.size() >= capacity - 1) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(element);
            queue.notifyAll();
        }
    }

    public T poll() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t =  queue.poll();
            queue.notifyAll();
            return t;
        }
    }

    public T peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }
}
