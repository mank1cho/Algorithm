// https://www.acmicpc.net/problem/16432
// 떡장수와 호랑이
// dfs

package boj;

import java.io.*;
import java.util.*;

public class BOJ_16432_G5_떡장수와호랑이 {

	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		dfs(0,-1);
		System.out.println(-1);
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][];
		visit = new boolean[N][];
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			arr[i] = new int[m+1];
			visit[i] = new boolean[m+1];
			arr[i][0] = m;
			for(int j = 0; j<m; ++j) {
				arr[i][j+1] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void dfs(int depth, int num) {
		if(depth==N) {
			System.out.println(sb);
			System.exit(0);
		}
		
		int length = arr[depth][0];
		for(int i = 0; i<length; ++i) {
			int now = arr[depth][i+1];
			if(now==num || visit[depth][i+1]) continue;
			visit[depth][i+1] = true;
			sb.append(now).append('\n');
			dfs(depth+1, now);
			sb.setLength(sb.length()-2);
		}
		
	}
	
}