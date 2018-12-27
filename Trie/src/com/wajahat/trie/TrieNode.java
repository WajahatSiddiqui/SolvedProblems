package com.wajahat.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean isCompleteWord;
	
	TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isCompleteWord = false;
	}

	@Override
	public String toString() {
		return children.toString();
	}
}
