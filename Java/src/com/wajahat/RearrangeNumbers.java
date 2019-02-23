package com.wajahat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Rearrange the numbers based on Odd and Even
 * Created by Wajahat
 **/
public class RearrangeNumbers {

    private List<Integer> rearrange(List<Integer> list) {
        List<Integer> odd = new ArrayList<>(list.size());
        List<Integer> even = new ArrayList<>(list.size());

        list.forEach(i-> {
            if (i % 2 == 0) {
                even.add(i);
            } else
                odd.add(i);
        });

        List<Integer> result = new ArrayList<>();
        result.addAll(odd);
        result.addAll(even);

        return result;
    }

    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return false;
        if (list1.size() != list2.size()) return false;

        int N = list1.size();
        for (int i = 0; i < N; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    @Test
    public void testRearrange() {
        List<Integer> test = Stream.of(1, 2, 6, 7, 8, 2, 0, 1).collect(Collectors.toList());
        //rearrange(test).forEach(System.out::println);
        //assertTrue(isEqual(Stream.of(1, 7, 1, 2, 6, 8, 2, 0).collect(Collectors.toList()), rearrange(test)));
/*        List<Integer> result = rearrange(test);
        int oddCount = 3;
        int evenCount = 5;
        int idx_odd = 0, idx_even = 0;
        for (Integer i : test) {
            if (i % 2 == 0)
                idx_even++;
            else
                idx_odd++;
        }
        assertEquals(oddCount, idx_odd);
        assertEquals(evenCount, idx_even);*/

        List<Integer> result = rearrange(test);

        // check for all odd

        // check for all even

        // if there are even or odd check if the list has
        int idx = 0;
        int oddCount = 3;
        for (Integer i : result) {
            if (idx < oddCount) {
                assertTrue(i % 2 != 0);
                idx++;
            }
             else if (idx == oddCount) {
                assertTrue(i % 2 == 0);
            }
        }
    }
}
