package com.wajahat.solution;

import java.util.Scanner;

public class ConnectedCellInGrid {
	
	private static int findMaxRegion(int [][]mat, int row, int col) {
		if (row < 0 || col < 0 || row >= mat.length || col >= mat[row].length || mat[row][col] == 0) {
			return 0;
		}
		mat[row][col] = 0;
		int size = 1;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r != row || c != col) {
					size += findMaxRegion(mat, r, c);
				}
			}
		}
		return size;
	}

	private static int findConnectedCell(int [][]mat) {
		int maxRegion = 0;
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[row].length; col++) {
				if (mat[row][col] == 1) {
					int size = findMaxRegion(mat, row, col);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		return maxRegion;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int [][] mat = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = scanner.nextInt();
				}
			}
			System.out.println(findConnectedCell(mat));
		}
	}

}
