// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
// 3307. 최장 증가 부분 수열
// dp

package swea;

import java.io.*;
import java.util.*;

public class SWEA_3307 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			for(int i = 0; i<N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = 1;
			}
			
			int ans = 1;
			for(int i = 1; i<N; ++i) {
				int val = 0;
				for(int j = 0; j<i; ++j) {
					if(arr[i]>arr[j] && dp[j] > val) {
						val = dp[j];
					}
				}
				dp[i] = val+1;
				ans = Math.max(ans, dp[i]);
			}

			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
