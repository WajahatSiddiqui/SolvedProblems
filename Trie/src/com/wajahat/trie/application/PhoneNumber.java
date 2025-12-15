// Write an algorithm to store and retrieve millions of phone numbers
// 10 digit phone number
// Prefix match is allowed and should return response to the user
// return true/false for partial prefix matches so that user can continue the search.
// File read/write operations can be skipped
// no regex allowed
//e.g. 4089211234, 2511501234, 2521501234
// 2-> true
// 3 -> false
// 25 -> true
// 252 -> true
// 4089 -> true
// 4089212 - false
// 2511501234 -> true

package com.wajahat.trie.application;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PhoneNumber {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        TrieNode root = new TrieNode();
        trie.insert(root, "4089211234");
        trie.insert(root, "2511501234");
        trie.insert(root, "2521501234");
        trie.insert(root, "7760076985");
        
        
        System.out.println(" Test 25->" + trie.lookup(root,"25"));
        System.out.println(" Test 252->" + trie.lookup(root,"252"));
        System.out.println(" Test 4089->" + trie.lookup(root, "4089"));
        System.out.println(" Test 4089212->" + trie.lookup(root, "4089212"));
        System.out.println(" Test 2511501234->" + trie.lookup(root, "2511501234"));
        System.out.println(" Test 2521520123411->" + trie.lookup(root, "2521520123411"));
        System.out.println(" Test 7760076985->" + trie.lookup(root, "7760076985"));

        trie.delete(root, "7760076985");
        System.out.println(" Test 7760076985 after delete ->" + trie.lookup(root, "7760076985"));
    }
    
    public static class TrieNode {
        char element;
        boolean end;
        TrieNode[] children;
        // int defaultSize = 10;
        
        public TrieNode() {
            this.children = new TrieNode[10];
            this.end = false;
        }
        
        public TrieNode(char element, boolean end) {
            this.element = element;
            this.end = false;
            this.children = new TrieNode[10];
        }
    }
    
    
    public static class Trie {
        public void insert(TrieNode head, String phoneNumber) {
            String normalizedPhoneNumber = phoneNumber.trim().toLowerCase();
            char [] chars = normalizedPhoneNumber.toCharArray();
            if (head == null) {
                head = new TrieNode();
            }
            TrieNode curr = head;
            for (char c : chars) {
                int index = c - '0';
                if (index < 0 || index > 9) continue; // ignore non-digit
                TrieNode node = curr.children[index];
                if (node == null) {
                    node = new TrieNode(c, false);
                    node.element = c;
                    curr.children[index] = node;
                }
                curr = node;
            }
            curr.end = true;
        }

        public void delete(TrieNode head, String phoneNumber) {
            String normalizedPhoneNumber = phoneNumber.trim().toLowerCase();
            char [] chars = normalizedPhoneNumber.toCharArray();
            if (head == null) {
                head = new TrieNode();
            }
            TrieNode curr = head;
            for (char c : chars) {
                int index = c - '0';
                TrieNode node = curr.children[index];
                if (node == null) {
                    throw new IllegalArgumentException("Unable to find the phoneNumber " + phoneNumber);
                }
                curr = node;
            }
            curr.end = false;
        }
        
        public boolean lookup(TrieNode head, String searchStr) {
            String normalized =  searchStr.trim().toLowerCase();
            char [] chars = normalized.toCharArray();
            
            if (head == null) return false;
            TrieNode curr = head;
            for (char c : chars) {
                int index = c - '0';
                if (index < 0 || index > 9) return false;
                if (curr == null || curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
            return true;
        }
    }
    
}
