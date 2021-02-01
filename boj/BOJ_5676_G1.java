// https://www.acmicpc.net/problem/5676
// 음주 코딩
// Segment Tree
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5676_G1{
	static long arr[];
	static long tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new long[N];

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = (1 << (h + 1));
		tree = new long[tree_size];

		init(1, 0, N - 1);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if (i == 1) {
				long k = Long.parseLong(st.nextToken());
				long diff = k-arr[--j];
				arr[j] = k;
				update(1,0,N-1,j,diff);
			} else if (i == 0) {
				int k = Integer.parseInt(st.nextToken());
				if(j>k) {
					int t = j;
					j = k;
					k = t;
				}
				sb.append(sum(1,0,N-1,j-1,k-1)).append('\n');
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


