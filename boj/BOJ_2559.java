// https://www.acmicpc.net/problem/2559
// 수열
// 누적합
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] dp = new int[N-K+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<K; ++i) {
			dp[0]+=arr[i];
		}
		
		int ans = dp[0];
		for(int i = 1; i<N-K+1; ++i) {
			dp[i] = dp[i-1]-arr[i-1]+arr[i+K-1];
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}