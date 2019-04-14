package com.wajahat.greedy;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Class Assign Meeting Rooms Based on greedy Strategy
 * Created by wajahat
 */
public class AssigningMeetingRooms {

    public int assign(List<Integer> startTime, List<Integer> endTime) {
        Collections.sort(startTime);
        Collections.sort(endTime);

        int count = 1; // first meeting is already selected
        int N = endTime.size();
        int j = 1;
        for (int i = 0; i < N - 1; i++) {
            if (startTime.get(j) > endTime.get(i))
                count++;
        }
        return count;
    }


    @Test
    public void testAssign() {
        assertEquals(2, assign(Stream.of(1, 3, 5).collect(Collectors.toList()), Stream.of(2, 6, 5).collect(Collectors.toList())));
    }
}
