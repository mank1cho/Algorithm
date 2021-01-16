// https://www.acmicpc.net/problem/11051
// 이항 계수1
// Math
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11051 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][N+1];
		for(int i = 1; i<=N; ++i) {
			dp[i][0] = 1;
			for(int j = 1; j<=N; ++j) {
				dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%10007;
			}
			dp[i][i] = 1;
		}
		
		System.out.print(dp[N][K]);
	}
}