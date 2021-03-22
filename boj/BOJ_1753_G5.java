// https://www.acmicpc.net/problem/1753
// 최단경로
// 다익스트라
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1753_G5 {
	
	static class Pair implements Comparable<Pair>{
		int v, w;	// 정점, 비용
		Pair(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(w, o.w);
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[] dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[K] = 0;
		
		ArrayList<Pair>[] edges = new ArrayList[V+1];
		
		for(int i = 0; i<=V; ++i) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Pair(v, w));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(K, 0));
		
		while(!pq.isEmpty()) {
			int cost = pq.peek().w;
			int node = pq.poll().v;
			for(int i = 0; i<edges[node].size(); ++i) {
				int newNode = edges[node].get(i).v;
				int newCost = edges[node].get(i).w;
				if(dis[newNode] > cost + newCost) {
					dis[newNode] = cost + newCost;
					pq.add(new Pair(newNode, cost+newCost));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; ++i) {
			if(dis[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(dis[i]);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
}