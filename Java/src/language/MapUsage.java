package language;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;

/**
 * Usage of All Maps
 * Created by Wajahat
 **/
public class MapUsage {

    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;

        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    List<Integer> insert(AbstractMap<Integer, Integer> map) {
        int []arr = {1, 0, -1};
        for (int i : arr) {
            map.put(i, i);
        }
        return new ArrayList<>(map.keySet());
    }

    @Test
    public void testInsert() {
        assertTrue(isEqual(Stream.of(0, -1, 1).collect(Collectors.toList()), insert(new HashMap<>())));
        assertTrue(isEqual(Stream.of(-1, 0, 1).collect(Collectors.toList()), insert(new TreeMap<>())));
        assertTrue(isEqual(Stream.of(1, 0, -1).collect(Collectors.toList()), insert(new LinkedHashMap<>())));
    }
}
