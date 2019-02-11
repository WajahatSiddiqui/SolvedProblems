import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Product of Maximum And Minimum
 * Created by Wajahat
 **/
public class ProductOfMaxMin {

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        List<Long> products = new ArrayList<>();
        int idx = 0, number;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(x.size());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(x.size(), Collections.reverseOrder());
        for (String opr : operations) {
            number = x.get(idx);
            switch (opr) {
                case "push":
                    minHeap.add(number);
                    maxHeap.add(number);
                    break;
                case "pop":
                    minHeap.remove(number);
                    maxHeap.remove(number);
                    break;
            }

            idx++;
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                products.add((long) (minHeap.peek() * maxHeap.peek()));
            } else {
                products.add(0L);
            }
        }
        return products;
    }

    @Test
    public void testMaxMin() {
        List<String> operations = Stream.of("push", "push", "push").collect(Collectors.toList());
        List<Integer> x = Stream.of(-1, 0, 10).collect(Collectors.toList());

        maxMin(operations, x).forEach(System.out::println);
    }
}
