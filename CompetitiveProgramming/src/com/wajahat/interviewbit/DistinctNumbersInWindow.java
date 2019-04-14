package com.wajahat.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctNumbersInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int N = A.size();
        int count = 0, distinct = 0;
        // fill the map with initial window
        for (int i = 0; i < K; i++) {
            if (map.containsKey(A.get(i))) {
                count = map.get(A.get(i))+1;
            } else {
                count = 1;
                distinct++;
            }
            map.put(A.get(i), count);
        }
        result.add(distinct);
        // move the sliding window and fill the map one by one removing previous element and adding new one in window
        for (int i = K; i < N; i++) {
            if (map.get(A.get(i-K)) == 1) {
                map.remove(A.get(i-K));
                distinct--;
            } else {
                count = map.get(A.get(i-K));
                map.put(A.get(i-K), count-1);
            }

            // add new entry
            if (map.containsKey(A.get(i))) {
                count = map.get(A.get(i))+1;
            } else {
                count = 1;
                distinct++;
            }
            map.put(A.get(i), count);
            result.add(distinct);
        }
        return result;
    }

    @Test
    public void testDNums() {
        dNums(new ArrayList<>(Stream.of(1, 2, 1, 3, 4, 3).collect(Collectors.toList())), 3).forEach(System.out::println);
    }
}
