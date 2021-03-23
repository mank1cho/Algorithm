// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {

	static final long mod = (long) (1e9+7);
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[1001];
		long[] dp2 = new long[1001];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 4;
		dp[4] = 10;
		dp2[1] = 0;
		dp2[2] = 2;
		dp2[3] = 4;
		dp2[4] = 7;
		
		for(int i = 5; i<=N; ++i) {
			dp2[i] = dp2[i-1]+dp2[i-2]+dp2[i-3];
			dp2[i] = dp2[i]%mod;
		}
		
		for(int i = 5; i<=N; ++i) {
			dp[i] = dp[i-1] + dp[i-2]*2 + dp[i-3]*3 + dp2[i-2] + dp2[i-3]*2;
			dp[i] = dp[i] % mod;
		}
		
		System.out.println(dp[N]);
	}
	
}