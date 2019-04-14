package com.designpatterns.iterator;

import java.util.Iterator;

public class MyCollection implements Iterable<Integer> {
    private int [] data;
    private int size;
    public MyCollection() {
        data = new int[10];
        size = 0;
    }

    public void add(int item) {
        data[size++] = item;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                return data[index++];
            }
        };
    }

}
