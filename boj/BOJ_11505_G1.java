// https://www.acmicpc.net/problem/11505
// 구간 곱 구하기
// Fenwick Tree (Binary Index Tree)
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11505_G1 {
	static final long mod = (long) 1e9+7;
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
		
		for(int i = 0; i<=N; ++i) {
			tree[i] = 1;
		}
		
		for(int i = 1; i<=N; ++i) {
			arr[i] = Long.parseLong(br.readLine());
			update(i, 1, arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		M+=K;
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				update(b, arr[b], c);
				arr[b] = c;
			}
			else {
				long x = multi((int) c);
				long y = multi(b-1);
				if(x == 0) sb.append(0);
				else sb.append(x/y);
				sb.append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public static void update(int i, long last, long next) {
		while(i<tree.length) {
			if(next == 0) tree[i] = 0;
			else if(last == 0) {
				tree[i] = next; //last = 1;
			}
			else tree[i] = tree[i]/last*next%mod;
			i += (i&-i);
		}
	}
	
	public static long multi(int i) {
		long ans = 1;
		while(i>0) {
			if(tree[i] == 0) return 0;
			ans = ans*tree[i]%mod;
			i-=(i&-i);
		}
		return ans;
	}
}
