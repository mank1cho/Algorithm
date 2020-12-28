// https://www.acmicpc.net/problem/1018 체스판 다시 칠하기
// brute force

package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static String[] board;
	static int N, M;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new String[N];
		for(int i = 0; i<N; ++i) {
			board[i] = br.readLine();
		}
		
		int ans = 8*8;
		for(int i = 0; i+7<N; ++i) {
			for(int j = 0; j+7<M; ++j) {
				ans = Math.min(ans,  find('W', i, j));
				ans = Math.min(ans,  find('B', i, j));
			}
		}
		System.out.print(ans);
	}
	
	static int find(char c, int x, int y) {
		int cnt = 0;
		for(int i = 0; i<8; ++i) {
			for(int j = 0; j<8; ++j) {
				if(board[x+i].charAt(y+j) != c) {
					++cnt;
				}
				if(c == 'B') c = 'W';
				else c = 'B';
			}
			if(c == 'B') c = 'W';
			else c = 'B';
		}
		return cnt;
	}
}