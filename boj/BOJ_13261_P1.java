// https://www.acmicpc.net/problem/13261
// 탈옥
// 분할정복을 이용한 최적화
package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13261_P1 {
	static int L, G;
	static long[] arr;
	static long[][] dp;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());	// 감옥사이즈
		int G = Integer.parseInt(st.nextToken());	// 간수
		
		arr = new long[L+1];
		dp = new long[G+1][L+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=L; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
			arr[i]+=arr[i-1];
		}
		
		
		for(int i = 1; i<=L; ++i) {
			dp[1][i] = sum(1,i);
		}
		
		for(int i = 2; i<=G; ++i) {
			func(i,0,L,0,L);
		}
		
		System.out.println(dp[G][L]);
	}
	
	static void func(int t, int l, int r, int p, int q) {
		if(l>r) return;
		int m = l + r >> 1;
		dp[t][m] = Long.MAX_VALUE;
		int mid = -1;
		for(int i = p; i<=q && i<=m; ++i) {
			long temp;
			if(i == 0) {
				temp = arr[m]*(m+1);
			}
			else temp = dp[t-1][i-1] + sum(i,m);
			if(dp[t][m]>temp) {
				dp[t][m] = temp;
				mid = i;
			}
		}
		func(t,l,m-1,p,mid);
		func(t,m+1,r,mid,q);
	}
	
	static long sum(long l, long r) {
		return (arr[(int) r] - arr[(int) (l-1)]) * (r-l+1);
	}
}