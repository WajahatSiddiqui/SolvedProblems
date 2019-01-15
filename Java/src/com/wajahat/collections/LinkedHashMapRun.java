package com.wajahat.collections;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * Running Linked HashMap
 * Created by Wajahat
 **/
public class LinkedHashMapRun{

    @Test
    public void testLinkedHashMap1() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(3, 0.75f, false);
        map.put(1, "abc");
        map.put(2, "xyz");
        map.put(3, "mno");
        map.put(4, "pqr");
        map.put(1, "lmn");

        map.entrySet().forEach( s -> System.out.println("Key: " + s.getKey() + " Value: " + s.getValue()));
    }

    @Test
    public void testLinkedHashMap2() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(3, 0.75f, true);
        map.put(1, "abc");
        map.put(2, "xyz");
        map.put(3, "mno");
        map.put(4, "pqr");
        map.put(1, "lmn");
        map.put(3, "nhg");

        map.entrySet().forEach( s -> System.out.println("Key: " + s.getKey() + " Value: " + s.getValue()));
    }
}
