import org.junit.Test;

import java.util.*;

/**
 * Customer location
 * Created by Wajahat
 **/
public class CustomerLocations {
    private static class Customer {
        public int x, y;
        public Double distance;
        public Customer(int x, int y, Double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    Double getDistance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }

    private class CustomerComparator implements Comparator<Customer> {
        public int compare(Customer c1, Customer c2) {
            return c1.distance.compareTo(c2.distance);
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants,
                                                    List<List<Integer>> allLocations,
                                                    int numRestaurants)
    {
        // WRITE YOUR CODE HERE
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        PriorityQueue<Customer> pq = new PriorityQueue<Customer>(new CustomerComparator());
        int currentLoc = 0;
        int x, y;
        for (int i = 0; i < totalRestaurants; i++) {
            x = allLocations.get(i).get(0);
            y = allLocations.get(i).get(1);
            pq.add(new Customer(x, y, getDistance(x, y)));
        }
        int count = 0;
        while (count < numRestaurants && !pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Customer c = pq.poll();
            list.add(c.x);
            list.add(c.y);
            result.add(list);
            count++;
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, -3));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(3, 4));
        List<List<Integer>> result = nearestVegetarianRestaurant(3, list, 2);
    }
}
