/*package com.wajahat.solution;

public class HuffmanDecode {
	private static class Node {
		int freq;
		char data;
		Node left;
		Node right;
		public Node() {
			left = right = null;
		}
	}
	
	private String decodeUtil(char [] c, int idx, Node root) {
		if (root == null) {
			return "";
		}
		if (c[idx] == 0) {
			decodeUtil(c, idx++, root.left);
		} else if (c[idx] == 1) {
			decodeUtil(c, idx++, root.right);
		} else if (root.data == '\0') {
			decodeUtil(c, )
		}
			
	}
	
	private void decode(String S, Node root) {
		char [] c = S.toCharArray();
		System.out.println(decodeUtil(c, 0, root));
	}

}
*/