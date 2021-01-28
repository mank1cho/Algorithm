// https://www.acmicpc.net/problem/11505
// 구간 곱 구하기
// Segment Tree
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11505_G1{
	static final long mod = (long) (1e9 + 7);
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
			arr[i] = Long.parseLong(br.readLine());
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
				--b;
				long c = Long.parseLong(st.nextToken());
				update(1,0,N-1,b,c);
			}
			else if(a == 2){
				int c = Integer.parseInt(st.nextToken());
				sb.append(multi(1,0,N-1,b-1,c-1)).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
	
	static long init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		else {
			return tree[node] = init(node*2, start, (start+end)/2)*init(node*2+1, (start+end)/2+1, end)%mod;
		}
	}
	
	static long update(int node, int start, int end, int index, long val) {
		if (index < start || index > end) return tree[node];
		if (start == end) return tree[node] = val;
		return tree[node] = 
				update(node*2, start, (start+end)/2, index, val)*update(node*2+1, (start+end)/2+1, end, index, val)%mod;
	}
	
	static long multi(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return 1;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		return multi(node*2, start, (start+end)/2, left, right)*multi(node*2+1, (start+end)/2+1, end, left, right)%mod;
	}
	
}
