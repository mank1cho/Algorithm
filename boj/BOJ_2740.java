// https://www.acmicpc.net/problem/2740
// 행렬 곱셈
// Math
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2740 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[M][K];
		for(int i = 0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<K; ++j) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = new int[N][K];
		
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<K; ++j) {
				for(int k = 0; k<M; ++k) {
					ans[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<K; ++j) {
				sb.append(ans[i][j]).append(' ');
			}sb.append('\n');
		}
		
		System.out.print(sb);
	}
}