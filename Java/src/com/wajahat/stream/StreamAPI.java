package com.wajahat.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrate Stream APIs
 * Created by Wajahat
 **/
public class StreamAPI {

    List<Integer> getDistinct(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
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
    public void testGetDistinct() {
        List<Integer> list = Stream.of(1, 2, 3, 1, 1, 1).collect(Collectors.toList());
        Assert.assertTrue(isEqual(Stream.of(1, 2, 3).collect(Collectors.toList()), getDistinct(list)));
    }
}
