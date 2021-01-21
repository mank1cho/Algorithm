// https://www.acmicpc.net/problem/2042
// 구간 합 구하기
// Fenwick Tree (Binary Index Tree)
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2042_G1 {
	static int N, M, K;
	static long[] arr;
	static long[] tree;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K =	Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N+1];
		
		for(int i = 1; i<=N; ++i) {
			arr[i] = Long.parseLong(br.readLine());
			update(i, arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		M+=K;
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(b, diff);
			}
			else {
				sb.append(sum((int) c) - sum(b-1)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public static void update(int i, long diff) {
		while(i<tree.length) {
			tree[i] += diff;
			i += (i&-i);
		}
	}
	
	public static long sum(int i) {
		long ans = 0;
		while(i>0) {
			ans += tree[i];
			i-=(i&-i);
		}
		return ans;
	}
}
