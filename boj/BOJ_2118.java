// https://www.acmicpc.net/problem/2118
// 두 개의 탑
// 누적 합
package boj;

import java.io.*;

public class BOJ_2118 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		int dp[] = new int[N+1];
		for(int i = 1; i<=N; ++i) {
			int x = Integer.parseInt(br.readLine());
			sum+=x;
			dp[i] = x+dp[i-1];
		}
		
		int ans = 0;
		for(int i = 1; i<N; ++i) {
			for(int j = i+1; j<=N; ++j) {
				ans = Math.max(ans, Math.min(dp[j]-dp[i], sum-dp[j]+dp[i]));
			}
		}
		System.out.println(ans);
	}
}