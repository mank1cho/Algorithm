// https://www.acmicpc.net/problem/1987
// 알파벳
// dfs
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1987_G4 {
	static int R, C, ans;
	static char[][] board;
    static int[][] visit;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
        visit = new int[R][C];
		for(int i=0; i<R; ++i) {
			board[i] = br.readLine().toCharArray();
		}
        
		dfs(0,0,1<<board[0][0]-'A',1);
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int bit, int cnt) {
        if(visit[x][y] == bit) return;
        visit[x][y] = bit;
		ans = Math.max(ans, cnt);
		for(int i = 0; i<4; ++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx==R||ny==C) continue;
			if((bit&(1<<board[nx][ny]-'A'))!=0) continue;
			dfs(nx, ny, bit|(1<<board[nx][ny]-'A'), cnt+1);
		}
	}
}