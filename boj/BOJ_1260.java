// https://www.acmicpc.net/problem/1260
// DFS와 BFS
// DFS, BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1260 {
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static int N, M, V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i<=N; ++i) {
			list[i] = new ArrayList<>();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i = 1; i<=N; ++i) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		Arrays.fill(visit, false);
		sb.append('\n');
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int x) {
		sb.append(x).append(' ');
		visit[x] = true;
		for(int i = 0; i<list[x].size(); ++i) {
			int next = list[x].get(i);
			if(!visit[next]) dfs(next);
		}
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visit[x] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(' ');
			for(int i = 0; i<list[now].size(); ++i) {
				int next = list[now].get(i);
				if(visit[next]) continue;
				visit[next] = true;
				q.offer(next);
			}
		}
	}
}

