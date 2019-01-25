package Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Class Implement Custom Iterator for List of Iterators
 * Created by wajahat
 */
public class CustomIterator<E> implements Iterator<E> {
    private List<Iterator<E>> list;
    private int idx;

    public CustomIterator(List<Iterator<E>> list) {
        this.list = list;
        idx = 0;
    }

    private boolean isEmpty() {
        return idx >= list.size();
    }

    @Override
    public boolean hasNext() {
        if (isEmpty()) return false;
        Iterator<E> iterator = list.get(idx);
        if (!iterator.hasNext()) {
            idx++;
            if (isEmpty()) return false;
            iterator = list.get(idx);
        }
        return iterator.hasNext();
    }

    @Override
    public E next() {
        Iterator<E> iterator = list.get(idx);
        if (!iterator.hasNext()) {
            idx++;
            if (isEmpty()) return null;
            iterator = list.get(idx);
        }

        return iterator.next();
    }
}
