// https://www.acmicpc.net/problem/10971
// 외판원 순외2
// 브루트포스
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10971 {
	
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int depth, int next, int sum) {
		if(depth == N-1) {
			if(map[next][0] == 0) return;
			ans = Math.min(ans, sum+map[next][0]);
			return;
		}
		
		for(int i = 1; i<N; ++i) {
			if(visit[i] || map[next][i] == 0) continue;
			visit[i] = true;
			if(sum+map[next][i] < ans) {
				dfs(depth+1, i, sum+map[next][i]);
			}
			visit[i] = false;
		}
		
	}
	
}