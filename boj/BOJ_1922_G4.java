// https://www.acmicpc.net/problem/1922
// 네트워크 연결
// MST
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1922_G4 {
	
	static class INFO implements Comparable<INFO>{
		int u, v, w;
		INFO(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(INFO o) {
			return Integer.compare(w, o.w);
		}
	}
	
	static int[] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i = 1; i<=N; ++i) {
			arr[i] = i;
		}
		
		INFO[] edges = new INFO[M];
		
		for(int i = 0; i<M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new INFO(u, v, w);
		}
		
		Arrays.sort(edges);
		
		int ans = 0;
		for(INFO e : edges) {
			if(union(e.u, e.v)) {
				ans+=e.w;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
	static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a==b) return false;
		arr[a] = b;
		return true;
	}
	
}
