// https://www.acmicpc.net/problem/14438
// 수열과 쿼리 17
// Segment Tree
package boj;

import java.io.*;
import java.util.*;

public class BOJ_14438_G1 {
	static int arr[];
	static int tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int tree_size = (1 << (h+1));
		tree = new int[tree_size];
		
		init(1, 0, N-1);
		
		int M = Integer.parseInt(br.readLine());
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				arr[--b] = c;
				update(1,0,N-1,b);
			}
			else if(a == 2) {
				sb.append(min(1,0,N-1,b-1,c-1)).append('\n');
			}
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
	
	static int update(int node, int start, int end, int index) {
		if (index < start || index > end) return tree[node];
		if(start == end) {
			return tree[node] = arr[index];
		}
		int mid = (start+end)/2;
		return tree[node] = Math.min(update(node*2, start, mid, index), update(node*2+1, mid+1, end, index));
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
