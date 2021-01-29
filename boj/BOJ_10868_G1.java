// https://www.acmicpc.net/problem/10868
// 최솟값
// Segment Tree
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10868_G1 {
	static int arr[];
	static int tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int tree_size = (1 << (h+1));
		tree = new int[tree_size];
		
		init(1, 0, N-1);
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(min(1,0,N-1,a-1,b-1)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		else {
			return tree[node] = Math.min(init(node*2, start, (start+end)/2), init(node*2+1, (start+end)/2+1, end));
		}
	}
	
	static int min(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return Integer.MAX_VALUE;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		return Math.min(min(node*2, start, (start+end)/2, left, right), min(node*2+1, (start+end)/2+1, end, left, right));
	}
	
}
