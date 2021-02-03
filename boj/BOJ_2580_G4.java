// https://www.acmicpc.net/problem/2580  스도쿠
// back tracking
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2580_G4 {
	static int[][] board = new int[9][9];
	static boolean flag = false;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i<9; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0);
	}
	
	static void func(int x) {
		if(flag == true) return;
		if(x == 81) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<9; ++i) {
				for(int j = 0; j<9; ++j) {
					sb.append(board[i][j]).append(' ');
				}sb.append('\n');
			}
			System.out.print(sb);
			flag = true;
			return;
		}
		
		int row = x/9;
		int col = x%9;
		
		if(board[row][col] != 0) {
			func(x+1);
			return;
		}
		
		for(int i = 1; i<10; ++i) {
			if(check(row, col, i) == true) {
				board[row][col] = i;
				func(x+1);
				board[row][col] = 0;
			}
		}
	}
	
	static boolean check(int row, int col, int x) {
		for(int i = 0; i<9; ++i) {
			if(board[row][i] == x) return false;
			if(board[i][col] == x) return false;
		}
		for(int i = 0; i<3; ++i) {
			for(int j = 0; j<3; ++j) {
				if(board[row/3*3+i][col/3*3+j] == x) return false;
			}
		}
		return true;
	}

}
