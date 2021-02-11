// https://www.acmicpc.net/problem/1106
// 호텔
// Dynamic Programming
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1106 {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int C = Integer.parseInt(st.nextToken());
       int N = Integer.parseInt(st.nextToken());
       int[][] arr = new int[N][2];
       
       int[] dp = new int[C];
       for(int i = 1; i<C; ++i) {
    	   dp[i] = 1<<20;
       }
       
       for(int i = 0; i<N; ++i) {
    	   st = new StringTokenizer(br.readLine());
    	   arr[i][0] = Integer.parseInt(st.nextToken());
    	   arr[i][1] = Integer.parseInt(st.nextToken());
       }
       
       int ans = Integer.MAX_VALUE;
       for(int i = 0; i<C; ++i) {
    	   for(int j = 0; j<N; ++j) {
    		   int nextIdx = i + arr[j][1];
    		   int nextValue = dp[i] + arr[j][0];
    		   if(nextIdx>=C) {
    			   ans = Math.min(nextValue, ans);
    		   }
    		   else {
    			   dp[nextIdx] = Math.min(dp[nextIdx], nextValue);
    		   }
    	   }
       }
       
       System.out.println(ans);
    }
}