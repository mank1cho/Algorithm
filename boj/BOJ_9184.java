// https://www.acmicpc.net/problem/9184  신나는 실행 함수
// dynamic programming
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9184 {
	int[][][] dp = new int[51][51][51];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			else if()
			
			
		}
	}
	
	public static int w(int a, int b, int c) {
		if(a>20 && b>20 && c>20) return w(20,20,20);
		else if(a<=0 && b<=0 && c<=0) return dp[a][b][c] = 1;
		
		return 0;
	}
}
