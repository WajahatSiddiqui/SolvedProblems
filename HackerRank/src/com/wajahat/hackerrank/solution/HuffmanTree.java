package com.wajahat.hackerrank.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {
    private static class Node {
        int freq;
        char data;
        Node left;
        Node right;
        public Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
            left = right = null;
        }
    }

    private Node buildTree(String str) {
        Queue<Node> queue = new PriorityQueue<Node>(str.length(),
                new Comparator<Node>() {
            @Override
            public int compare(Node left, Node right) {
                if (left.freq == right.freq)
                    return 0;
                if (left.freq < right.freq)
                    return -1;
                return 1;
            }
        });

        // Calculate the frequency of characters and sort based on values
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int N = str.length();
        for (int i = 0; i < N; i++) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }
          // Iterate while size of heap doesn't become 1
        Node left, right, top;
        while (queue.size() != 1) {
            // Extract the two minimum freq items from min heap
            left = queue.poll();
            right = queue.poll();

            // Create a new internal node with frequency equal to the
            // sum of the two nodes frequencies. Make the two extracted
            // node as left and right children of this new node. Add
            // this node to the min heap
            // '$' is a special value for internal nodes, not used
            top = new Node('$', left.freq + right.freq);
            if (left.freq <= right.freq) {
                top.left = left;
                top.right = right;
            } else {
                top.left = right;
                top.right = left;
            }
            queue.add(top);
        }
        return queue.peek();
    }

    // Prints huffman codes from the root of Huffman Tree.
    private static void printCodes(Node root, String str) {
        if (root == null)
            return;

        if (root.data != '$')
            System.out.println(root.data + ": "+str);

        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    private void encode(Node root, String str, int index, String encoded) {
        if (root == null)
            return;

        if (root.data == str.charAt(index)) {
            System.out.print(encoded);
            index++;
            encoded = "";
        }

        encode(root.left, str, index, encoded + "0");
        encode(root.right, str, index, encoded + "1");
    }

    private String decode(Node root, String encode) {
        return null;
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        String str = "aaabbccddddeeff";
        Node root = huffmanTree.buildTree(str);
        printCodes(root, "");
        huffmanTree.encode(root, "acfd", 0, "");
        //System.out.println(encode);
        /*System.out.println(huffmanTree.decode(root, encode));*/
    }

}
