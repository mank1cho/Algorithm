// https://www.acmicpc.net/problem/18436
// 수열과 쿼리37
// Segment Tree
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18436_G1{
	static int arr[];
	static int tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int tree_size = (1 << (h+1));
		tree = new int[tree_size+1];
		
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				if(arr[b]%2 != c%2) {
					arr[b] = c;
					update(1,1,N,b,c);
				}
			}
			else if(a == 2){	// 짝수의 갯수
				sb.append(getCnt(1,1,N,b,c)).append('\n');
			}
			else if(a == 3) {	// 홀수의 갯수
				sb.append(c-b+1-getCnt(1,1,N,b,c)).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
	
	static int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start]%2==0 ? 1:0;	//짝수인 것 저장.
		}
		else {
			return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
		}
	}
	
	static void update(int node, int start, int end, int index, int num) {
		if (index < start || index > end) return;
		if(num%2==1) --tree[node];
		else ++tree[node];
		if(start==end) {
			tree[node] = arr[start]%2==0 ? 1:0;
			return;
		}
		update(node*2, start, (start+end)/2, index, num);
		update(node*2+1, (start+end)/2+1, end, index, num);
	}
	
	static int getCnt(int node, int start, int end, int left, int right) {
		if(left>end || right<start) {
			return 0;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		return getCnt(node*2, start, (start+end)/2, left, right) + getCnt(node*2+1, (start+end)/2+1, end, left, right);
	}
	
}