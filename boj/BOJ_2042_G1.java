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


/* segmentTree

import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static long arr[];
	static long tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int tree_size = (1 << (h+1));
		tree = new long[tree_size];
		
		init(1, 0, N-1);
		
		M+=K;
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 1) {
				long c = Long.parseLong(st.nextToken());
				long diff = c - arr[--b];
				arr[b] = c;
				update(1,0,N-1,b,diff);
			}
			else if(a == 2){
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(1,0,N-1,b-1,c-1)).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
	
	static long init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		else {
			return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
		}
	}
	
	static void update(int node, int start, int end, int index, long diff) {
		if (index < start || index > end) return;
		tree[node] = tree[node] + diff;
		if(start!=end) {
			update(node*2, start, (start+end)/2, index, diff);
			update(node*2+1, (start+end)/2+1, end, index, diff);
		}
	}
	
	static long sum(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return 0;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
	}
	
}

*/
