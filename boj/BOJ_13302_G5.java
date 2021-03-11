// https://www.acmicpc.net/problem/13302
// 리조트
// dfs, dp
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_13302_G5 {
 
	static int N,M;
	static boolean[] no;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        no = new boolean[N+1];
        dp = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; ++i) {
        	no[Integer.parseInt(st.nextToken())] =  true;
        }
        for(int i = 0; i<=N; ++i) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(func(1,0));
    }
    
    public static int func(int day, int coupon) {
    	if(N<day) return 0;
    	if(dp[day][coupon]!=Integer.MAX_VALUE) return dp[day][coupon];
    	if(no[day]) return dp[day][coupon] = func(day+1, coupon);

    	dp[day][coupon] = Math.min(dp[day][coupon], func(day+1, coupon)+10000);
    	dp[day][coupon] = Math.min(dp[day][coupon], func(day+3, coupon+1)+25000);
    	dp[day][coupon] = Math.min(dp[day][coupon], func(day+5, coupon+2)+37000);
    	if(coupon>=3) dp[day][coupon] = Math.min(dp[day][coupon], func(day+1, coupon-3));
    	
    	return dp[day][coupon];
    }
    
}