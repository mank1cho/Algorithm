// https://www.acmicpc.net/problem/16991
// 외판원 순회3
// DFS, DP
package boj;

import java.io.*;
import java.util.*;

public class BOJ_16991_G1 {

	static final double INF = 1<<25;
	static int N;
	static double[][] map, dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		map = new double[N][N];
		dp = new double[N][1<<N];
		
		for(int i = 0; i<N; ++i) {
			Arrays.fill(dp[i], INF);
		}
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				map[i][j] = getDistance(arr, i, j);
			}
		}

		System.out.println(TSP(0,1));
	}
	
	public static double TSP(int node, int visit) {
		if(visit == (1<<N)-1) {
			return map[node][0];
		}
		
		if(dp[node][visit] != INF) {
			return dp[node][visit];
		}
		
		for(int i = 0; i<N; ++i) {
			if(i != node && (visit&(1<<i)) == 0) {
				dp[node][visit] = Math.min(dp[node][visit], map[node][i]+TSP(i, visit|(1<<i)));
			}
		}
		
		return dp[node][visit];
	}
	
	
	public static double getDistance(int[][] arr, int i, int j) {
		 int x = arr[i][0] - arr[j][0];
		 int y = arr[i][1] - arr[j][1];
		 x = x*x;
		 y = y*y;
		 return Math.sqrt(x+y);
	}
	
	
}