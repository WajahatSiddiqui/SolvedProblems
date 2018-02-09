package com.wajahat.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> children;
	public boolean isCompleteWord;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isCompleteWord = false;
	}

	@Override
	public String toString() {
		return children.toString();
	}
}
