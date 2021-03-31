package boj;

import java.io.*;
import java.util.*;
// alt s r a r 자동으로 getter setter 생성

public class BOJ_ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];		// 20 이 최대
		// 비용, 고객
		
		for(int i = 0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[C+1];		// 인덱스 = 고객 수 , 값 = 비용
		Arrays.fill(dp, 1<<25);
		dp[0] = 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i<C; ++i) {
			for(int j = 0; j<N; ++j) {
				int numberOfCustomer = i + arr[j][1];
				int cost = dp[i] + arr[j][0];
				// arr[0] = 3원, 4명 ,, dp[0] -> dp[4] = 3. 4명을 유치하는데 3원 든다. 일단은.
				// noc == c 우리가 원하는 순간. c가 넘어가도 됨.
				if(numberOfCustomer<C)
					dp[numberOfCustomer] = Math.min(dp[numberOfCustomer], cost);
				else {
					ans = Math.min(ans, cost);
				}
			}
		}
		
		System.out.println(ans);
	}

}