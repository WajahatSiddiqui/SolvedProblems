package com.wajahat.interviewbit.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return new ArrayList<>(Collections.emptyList());
        }
        // remove any leading zeros
        int N = A.size();
        for (int i = 0;  i < N; i++) {
            if (A.get(i) != 0) {
                A = new ArrayList<>(A.subList(i, N));
                break;
            }
        }

        N = A.size();

        Collections.reverse(A);
        int carry = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sum = carry + A.get(i) + 1;
            } else {
                sum = carry + A.get(i);
            }
            carry = sum/10;
            if (carry == 1) {
                A.set(i, 0);
            } else {
                if (A.get(i) != sum) {
                    A.set(i, sum);
                }
            }
        }
        if (carry == 1) {
            A.add(1);
        }
        Collections.reverse(A);
        return A;
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
    public void testPlusOne() {
        assertTrue(isEqual(Stream.of(1, 2, 4).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(0, 0, 1, 2, 3).collect(Collectors.toList())))));
        assertTrue(isEqual(Stream.of(3, 4, 6).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(3, 4, 5).collect(Collectors.toList())))));
        assertTrue(isEqual(Stream.of(1, 2, 4).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(1, 2, 3).collect(Collectors.toList())))));
        assertTrue(isEqual(Stream.of(1, 2, 4).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(0, 1, 2, 3).collect(Collectors.toList())))));
        assertTrue(isEqual(Stream.of(2).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(1).collect(Collectors.toList())))));
        assertTrue(isEqual(Stream.of(1).collect(Collectors.toList()), plusOne(new ArrayList<>(Stream.of(0).collect(Collectors.toList())))));
        assertTrue(isEqual(Collections.emptyList(), plusOne(null)));
        assertTrue(isEqual(Collections.emptyList(), plusOne(new ArrayList<>(Collections.emptyList()))));
        assertTrue(isEqual(Stream.of(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).collect(Collectors.toList())
                , plusOne(new ArrayList<>(Stream.of( 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9).collect(Collectors.toList())))));
    }
}
