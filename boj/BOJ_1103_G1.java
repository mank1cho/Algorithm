// https://www.acmicpc.net/problem/1103
// 게임
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1103_G1 {
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static char[][] map;
	static boolean[][] visit;
	static int[][] dp;
	static boolean flag = false;
	static int N, M;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new boolean[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i<N; ++i) {
			map[i] = br.readLine().toCharArray();
		}

		int ans = dfs(0,0);
		if(flag) System.out.println(-1);
		else System.out.println(ans);
	}
	
	public static int dfs(int x, int y) {
		if(flag||x<0||y<0||x>=N||y>=M||map[x][y] == 'H') return 0;
		if(visit[x][y]) {flag = true; return 0;}
		if (dp[x][y] > 0) return dp[x][y];
		
		visit[x][y] = true;
		for(int i = 0; i<4; ++i) {
			int nx = x+dx[i]*(map[x][y]-'0');
			int ny = y+dy[i]*(map[x][y]-'0');
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
		}
		visit[x][y] = false;
		return dp[x][y];
	}
	
} 
