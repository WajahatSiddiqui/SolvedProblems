package com.wajahat.hackerrank.lrucache;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LruCacheTest {
	
	private LruCache<Integer, String> lruCache;
	
	public LruCacheTest() {
		lruCache = new LruCache<Integer, String>(4);
		lruCache.put(10, "a");
		lruCache.put(20, "b");
		lruCache.put(30, "c");
	}

	@Test
	public void testGet() {
		assertEquals(lruCache.get(20), "b");
	}
	
	@Test
	public void testSize() {
		assertEquals(lruCache.size(), 3);
	}
	
	@Test
	public void testPut() {
		lruCache.put(40, "d");
		assertTrue(lruCache.contains(40));
		assertEquals(lruCache.get(40), "d");
		assertEquals(lruCache.size(), 4);
		System.out.println("testPut : " + lruCache);
		
		// add more elements
		lruCache.put(50, "e");
		System.out.println("testPut : " + lruCache);
		lruCache.put(60, "r");
		lruCache.put(70, "t");
		System.out.println("testPut : " + lruCache);
		assertTrue(lruCache.contains(50));
		assertTrue(lruCache.contains(60));
		assertTrue(lruCache.contains(70));
		
		assertFalse(lruCache.contains(10));
		assertFalse(lruCache.contains(20));
		assertFalse(lruCache.contains(30));
		
		assertEquals(lruCache.size(), 4);
		
		// add same element
		lruCache.put(70, "s");
		assertTrue(lruCache.contains(70));
		assertEquals(lruCache.get(70), "s");
		assertEquals(lruCache.size(), 4);
		
		lruCache.put(40, "z");
		assertTrue(lruCache.contains(40));
		assertEquals(lruCache.get(40), "z");
		assertEquals(lruCache.size(), 4);

		System.out.println("testPut : " + lruCache);

		assertEquals(lruCache.get(60), "r");
		System.out.println("testPut: " + lruCache);
	}
	
	@Test
	public void testContains() {
		assertTrue(lruCache.contains(20));
		assertFalse(lruCache.contains(120));
	}
	
	@Test
	public void testRemove() {
		assertEquals(lruCache.remove(10), "a");
		assertEquals(lruCache.size(), 2);
		assertFalse(lruCache.contains(10));
		
		// remove invalid key
		assertEquals(lruCache.remove(100), null);
		
		System.out.println("testRemove : " + lruCache);
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
	public void testRefer() {
		LruCache<Integer, String> lruCache = new LruCache<>(4);
		lruCache.put(1, "a");
		lruCache.put(2, "b");
		lruCache.put(3, "c");
		lruCache.put(1, "d");
		lruCache.put(4, "e");
		lruCache.put(5, "f");
		Assert.assertTrue(isEqual(Stream.of(5, 4, 1, 3).collect(Collectors.toList()),
				lruCache.getQueue()));
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + lruCache);
	}

}
