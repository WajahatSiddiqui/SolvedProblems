package com.wajahat.hashtable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashTableTest {
	
	private HashTable<Integer, String> hashTable;
	
	public HashTableTest() {
		hashTable = new HashTable<Integer, String>();
		hashTable.put(10, "abc");
		hashTable.put(11, "pqr");
		hashTable.put(12, "xyz");
	}

	@Test
	public void testGet() {
		assertEquals(hashTable.get(11), "pqr");
	}

	@Test
	public void testPut() {
		hashTable.put(40, "lmn");
		assertTrue(hashTable.contains(40));
		assertEquals(hashTable.get(40), "lmn");
		
		System.out.println("testPut : " + hashTable);
	}

	@Test
	public void testContains() {
		assertTrue(hashTable.contains(12));
		assertFalse(hashTable.contains(40));
	}
	
	@Test
	public void size() {
		assertEquals(hashTable.size(), 3);
	}
	
	@Test
	public void remove() {
		hashTable.remove(12);
		assertFalse(hashTable.contains(12));
		assertEquals(hashTable.size(), 2);
		
		System.out.println("remove : " + hashTable);
	}
	
	@Test
	public void testPutSame() {
		hashTable.put(12, "ooo");
		assertTrue(hashTable.contains(12));
		assertEquals(hashTable.get(12), "ooo");
		assertEquals(hashTable.size(), 3);
		System.out.println("testPutSame : " + hashTable);
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + hashTable);
	}
}
