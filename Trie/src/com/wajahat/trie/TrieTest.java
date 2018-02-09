package com.wajahat.trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {
	
	private Trie trie;
	
	public TrieTest() {
		trie = new Trie();
		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");
	}

	@Test
	public void testInsert() {
		trie.insert("opq");
		assertTrue(trie.contains("opq"));
		assertEquals(6, trie.size());
		System.out.println("testInsert : " + trie);
	}
	
	@Test
	public void testDelete() {
		trie.delete("lmn");
		assertFalse(trie.contains("lmn"));
		assertEquals(4, trie.size());
		System.out.println("testDelete : " + trie);		
	}
	
	@Test
	public void testContains() {
		assertTrue(trie.contains("abc"));
		assertTrue(!trie.contains("zwe"));
	}
	
	@Test
	public void testSearchPrefix() {
		assertTrue(trie.searchPrefix("cd"));
		assertTrue(!trie.searchPrefix("il"));
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + trie);
	}
}
