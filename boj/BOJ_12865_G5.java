// https://www.acmicpc.net/problem/12865
// 평범한 배낭
// Dynamic Programming, 냅색
package boj;

import java.io.*;
import java.util.*;

public class BOJ_12865_G5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K+1];
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for(int j = K; j>=w; --j) {
				dp[j] = dp[j]<dp[j-w]+v?dp[j-w]+v:dp[j];
			}
		}
		System.out.println(dp[K]);
	}
}