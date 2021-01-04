// https://www.acmicpc.net/problem/9461  파도반 수열
// Dynamic Programming
package boj;

import java.io.*;
import java.util.*;


public class BOJ_9461 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[100];
		dp[0] = dp[1] = dp[2] = 1;
		for(int i = 3; i<100; ++i)
			dp[i]=dp[i-3]+dp[i-2];

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- >0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N-1]).append('\n');
		}
		System.out.print(sb);
	}
}