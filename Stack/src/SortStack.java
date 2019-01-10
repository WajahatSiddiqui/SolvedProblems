import com.wajahat.stack.Stack;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertTrue;

/**
 * Class Implement Sorted Stack
 * Created by wajahat
 */
public class SortStack {
    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int t = s.pop();
            while (!r.isEmpty() && r.top() < t) {
                s.push(r.pop());
            }
            r.push(t);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;

        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    @Test
    public void testSort() {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(4);

        sort(s);

        assertTrue(isEqual(Stream.of(5, 4, 3, 2, 1).collect(Collectors.toList()),
                s.toList()));

    }
}
