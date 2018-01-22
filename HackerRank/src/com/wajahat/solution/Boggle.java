package com.wajahat.solution;

public class Boggle {

	private static int[] getRC(char [][] boggle, char ch) {
		int [] rc = new int[2];
		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[0].length; j++) {
				if (boggle[i][j] == ch) {
					rc[0] = i;
					rc[1] = j;
				}
			}
		}
		return rc;
	}
	
	private static int dfs(char [][] boggle, int r, int c, boolean[][] visited, String str, int index) {
		if (r < 0 || c < 0 || r >= boggle.length || c >= boggle[r].length || visited[r][c] || boggle[r][c] != str.charAt(index)) {
			return 0;
		}
		if (boggle[r][c] == str.charAt(index)) {
			visited[r][c] = true;
			index++;
		}
		int len = 1;
		for (int row = r-1; row <= r+1; row++) {
			for (int col = c-1; col <= c+1; col++) {
				if (row != r || col != c) {
					len += dfs(boggle, row, col, visited, str, index);
				}
			}
		}
		return len;
	}

	private static boolean isWord(char [][]boggle, String str) {
		boolean [][] visited = new boolean[boggle.length][boggle[0].length];
		int [] rc = getRC(boggle, str.charAt(0));
		return str.length() == dfs(boggle, rc[0], rc[1],  visited, str, 0);
	}

	public static void main(String[] args) {
		String [] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
		char [][] boggle = {{'G','I','Z'},
				{'U','E','K'},
				{'Q','S','E'}};

		for (String str : dictionary) {
			if (isWord(boggle, str)) {
				System.out.println(str + " is present");
			} else {
				System.out.println(str + " is not present");
			}
		}
	}
}
