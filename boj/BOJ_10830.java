// https://www.acmicpc.net/problem/10830
// 행렬 제곱
// Divide and Conquer, Math, Matrix
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10830 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long[][] matrix = new long[N][N];
		long[][] ans = new long[N][N];
		
		for(int i = 0; i<N; ++i) {
			ans[i][i] = 1; //단위행렬로 초기화
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				matrix[i][j] = Long.parseLong(st.nextToken());
			}
		}
			
		while(B>0) {			
			if(B%2 == 1) {
				multi(N, ans, matrix);
			}
			B/=2;
			multi(N, matrix, matrix);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				sb.append(ans[i][j]).append(' ');
			}sb.append('\n');
		}
		System.out.print(sb);
	}
	
	public static void multi(int N, long[][] a, long[][] b) {
		long[][] temp = new long[N][N];	
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				for(int k = 0; k<N; ++k) {
					temp[i][j] += a[i][k] * b[k][j];
				}
				temp[i][j] %= 1000;
			}
		}	

		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				a[i][j] = temp[i][j];
			}
		}
		
	}

}