// https://www.acmicpc.net/problem/1275
// 커피숍2
// 세그먼트트리
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_1275_G1 {
	
	static long arr[];
	static long tree[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new long[N];
 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; ++i) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int tree_size = (1 << (h+1));
		tree = new long[tree_size];
		
		init(1, 0, N-1);
        
		StringBuilder sb = new StringBuilder();
		while(Q-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x>y) {
				int t = x; x = y; y = t;
			}
			sb.append(sum(1,0,N-1,x-1,y-1)).append('\n');
			long diff = b - arr[--a];
			arr[a] = b;
			update(1,0,N-1,a,diff);
		}
		System.out.println(sb);
    }
    
    static long init(int node, int start, int end) {
    	if(start==end) {
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