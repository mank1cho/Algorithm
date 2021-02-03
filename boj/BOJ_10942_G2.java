// https://www.acmicpc.net/problem/10942
// 팰린드롬?
// Dynamic Programming
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10942_G2 {
	
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int[] arr = new int[n+1];
		 boolean[][] dp = new boolean[n+1][n+1];
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0; i<n; ++i) {
			 arr[i] = Integer.parseInt(st.nextToken());
			 dp[i][i] = true;
			 
			 if(i>0 && arr[i-1] == arr[i]) {
				 dp[i-1][i] = true;
			 }
			 
		 }
		 
		 for(int k = 2; k<n; ++k) {
			 for(int left = 0; left<=n-k; ++left) {
				 int right = left + k;
				 
				 if(arr[left] == arr[right] && dp[left+1][right-1] == true) {
					 dp[left][right] = true;
				 }
				 
			 }
		 }

		 st = new StringTokenizer(br.readLine());
		 int m = Integer.parseInt(st.nextToken());
		 for(int i = 0; i<m; ++i) {
			 st = new StringTokenizer(br.readLine());
			 int left = Integer.parseInt(st.nextToken());
			 int right = Integer.parseInt(st.nextToken());
			 bw.write(dp[left-1][right-1] ? "1":"0");
			 bw.write('\n');
		 }
		 bw.flush();
		 bw.close();
	}
}