// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] line = new int[K][N];
		int[][] move = new int[N][K * (K - 1)];

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < K; ++j) {
				line[j][i] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < K * (K - 1); ++j) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			line[i][N - 1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[K][N];

		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < K; ++j) {
				dp[j][i] = Integer.MAX_VALUE;
				for(int k = 0; k<K; ++k) {
					if(k==j) dp[j][i] = Math.min(dp[j][i], dp[j][i-1]+line[j][i]);
					else {
						dp[j][i] = Math.min(dp[j][i], dp[k][i-1]+line[k][i]+move[k][j]);
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<K; ++i) {
			ans = Math.min(ans, dp[i][N-1]);
		}
		System.out.println(ans);
	}

}
