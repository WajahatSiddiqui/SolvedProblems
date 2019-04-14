
package com.wajahat.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        int N = A.size();

        for (int i = 0; i < N-1; i+=2) {
            int tmp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, tmp);
        }
        return A;
    }

    @Test
    public void testWave() {
        System.out.print(wave(new ArrayList<>(Stream.of(3, 2, 1, 4).collect(Collectors.toList()))));
        System.out.print(wave(new ArrayList<>(Stream.of( 5, 1, 3, 2, 4 ).collect(Collectors.toList()))));
    }
}
