package com.wajahat.solution;

import java.util.Scanner;

public class ConnectedCellInGrid {
	
	private static boolean isConnected(int [][]mat, int n, int m, int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1;
	}
	
	private static int dfs(int [][]mat, int x, int y, int n, int m, int []dx, int[] dy) {
		mat[x][y] = 0;
		for (int i = 0; i < dx.length; i++) {
			int _x = x+dx[i];
			int _y = y+dy[i];
			if (isConnected(mat, n, m, _x, _y)) {
				return dfs(mat, _x, _y, n, m, dx, dy) + 1;
			}
		}
		return 1;
	}
	
	private static int findConnectedCell(int [][]mat, int n, int m) {
		int cell = 0;

		int []dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int []dy = {-1, 0, 1, -1, 1, -1, 0, 1};
			
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 1) {
					cell++;
					cell = dfs(mat, i, j, n, m, dx, dy);
					if (cell > max) {
						max = cell;
					}
					cell = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int [][] mat = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = scanner.nextInt();
			}
		}
		System.out.println(findConnectedCell(mat, n, m));
		scanner.close();

	}

}
