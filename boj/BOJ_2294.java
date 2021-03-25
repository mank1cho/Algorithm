// https://www.acmicpc.net/problem/2294
// 동전 2
// dp
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2294 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i<n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > k) continue;
			dp[arr[i]] = 1;
		}
		
		for(int i = 0; i<=k; ++i) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			for(int j = 0; j<n; ++j) {
				int now = arr[j];
				if(i+now>k) continue;
				dp[i+now] = Math.min(dp[i+now], dp[i]+1);
			}
			
		}
		if(dp[k] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[k]);
		
	}

}