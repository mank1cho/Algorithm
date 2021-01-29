// https://www.acmicpc.net/problem/2357
// 최솟값과 최댓값
// Segment Tree
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2357_G1 {
	static int arr[];
	static int minTree[];
	static int maxTree[];
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
		minTree = new int[tree_size];
		maxTree = new int[tree_size];
		
		initMin(1, 0, N-1);
		initMax(1, 0, N-1);
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(min(1,0,N-1,a-1,b-1)).append(' ');
			sb.append(max(1,0,N-1,a-1,b-1)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int initMin(int node, int start, int end) {
		if(start == end) {
			return minTree[node] = arr[start];
		}
		else {
			return minTree[node] = Math.min(initMin(node*2, start, (start+end)/2), initMin(node*2+1, (start+end)/2+1, end));
		}
	}
	
	static int min(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return Integer.MAX_VALUE;
		}
		if(left<=start&&end<=right) {
			return minTree[node];
		}
		return Math.min(min(node*2, start, (start+end)/2, left, right), min(node*2+1, (start+end)/2+1, end, left, right));
	}
	
	static int initMax(int node, int start, int end) {
		if(start == end) {
			return maxTree[node] = arr[start];
		}
		else {
			return maxTree[node] = Math.max(initMax(node*2, start, (start+end)/2), initMax(node*2+1, (start+end)/2+1, end));
		}
	}
	
	static int max(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return Integer.MIN_VALUE;
		}
		if(left<=start&&end<=right) {
			return maxTree[node];
		}
		return Math.max(max(node*2, start, (start+end)/2, left, right), max(node*2+1, (start+end)/2+1, end, left, right));
	}
	
}
