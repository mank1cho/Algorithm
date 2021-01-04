// https://www.acmicpc.net/problem/1932  정수 삼각형
// Dynamic Programming

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1932{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		dp[0][0] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken()) + dp[i-1][0];
			for(int j = 1; j<i; ++j) {
				dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
			dp[i][i] = Integer.parseInt(st.nextToken()) + dp[i-1][i-1];
		}
		
		int ans = 0;
		for(int i = 0; i<N; ++i)
			ans = Math.max(ans, dp[N-1][i]);
		System.out.print(ans);
	}
}