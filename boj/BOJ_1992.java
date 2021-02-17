// https://www.acmicpc.net/problem/1992
// 쿼드트리
// Divide and conquer
package boj;

import java.io.*;

public class BOJ_1992 {
	static String[] arr;
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		sb = new StringBuilder();
		
		for(int i = 0; i<N; ++i) {
			arr[i] = br.readLine();
		}

		quadTree(N, 0, 0);
		System.out.print(sb);
	}
	
	public static void quadTree(int n, int x, int y) {
		if(n == 1) {
			sb.append(arr[x].charAt(y));
			return;
		}
		
		int cnt = 0;
		for(int i = 0; i<n; ++i) {
			for(int j = 0; j<n; ++j) {
				if(arr[x+i].charAt(y+j) == '0') {
					++cnt;
				}
			}
		}
		
		if(cnt == n*n) {
			sb.append(0);
			return;
		}
		else if(cnt == 0) {
			sb.append(1);
			return;
		}
		else {
			sb.append('(');
			quadTree(n/2, x, y);
			quadTree(n/2, x, y + n/2);
			quadTree(n/2, x + n/2, y);
			quadTree(n/2, x + n/2, y + n/2);
			sb.append(')');
		}
	}
}