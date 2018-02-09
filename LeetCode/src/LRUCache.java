import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCache {

	private int capacity;
	private ArrayDeque<Integer> queue;
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<Integer>(capacity);
    }
    
    public int get(int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void put(int key, int value) {
    	if (queue.contains(key)) {
    		queue.remove(key);
    	}
    	
    	if (queue.size() >= capacity) {
    		map.remove(queue.pollLast());
    	}
        map.put(key, value);
        queue.addFirst(key);
    }
    
    private void print() {
    	Iterator<Integer> it = queue.iterator();
    	
    	while (it.hasNext()) {
    		System.out.print(it.next() + " ");
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache lruCache = new LRUCache(3);
    	int [] a = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
    	
    	for (int i = 0; i < 12; i++) {
    		lruCache.put(a[i], a[i]);
    	}
    	lruCache.print();
	}
}

