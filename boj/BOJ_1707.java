// https://www.acmicpc.net/problem/
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1707 {
	static int V, E;
	static int[] nodeColor;
	static ArrayList<Integer>[] adj;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			nodeColor = new int[V+1];
			adj = new ArrayList[V+1];
			
			for(int i = 1; i<=V; ++i) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<E; ++i) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			
			for(int i = 1; i<=V; ++i) {
				if(nodeColor[i] == 0) {
					dfs(i, 1);
				}
			}
			
			if(check()) {
				sb.append("YES").append('\n');
			}
			else {
				sb.append("NO").append('\n');
			}

		}
		
		System.out.print(sb);
	}
	
	static void dfs(int nodeNum, int color) {
		nodeColor[nodeNum] = color;
		for(int i = 0; i<adj[nodeNum].size(); ++i) {
			int next = adj[nodeNum].get(i);
			if(nodeColor[next] == 0) {
				dfs(next, 3-color);
			}
		}
	}
	
	static boolean check() {
		for(int i = 1; i<=V; ++i) {
			for(int j = 0; j<adj[i].size(); ++j) {
				int next = adj[i].get(j);
				if(nodeColor[i] == nodeColor[next])
					return false;
			}
		}
		return true;
	}
}