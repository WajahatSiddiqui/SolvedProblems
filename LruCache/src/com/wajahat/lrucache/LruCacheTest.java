package com.wajahat.lrucache;

import org.junit.Test;

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
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + lruCache);
	}

}
