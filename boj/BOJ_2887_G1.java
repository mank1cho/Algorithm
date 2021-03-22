// https://www.acmicpc.net/problem/2887
// 행성 터널
// MST, 크루스칼
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2887_G1 {
	
	static class Planet{
		int x, y, z, idx;
		Planet(int x, int y, int z, int idx){
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	
	static class Edge{
		int u, v, w;
		Edge(int u , int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int[] parent;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Planet[] planets = new Planet[N];
		Edge[] edges = new Edge[3*N-3];
		parent = new int[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(x, y, z, i);
			parent[i] = i;
		}
		
		Arrays.sort(planets, (p1, p2)->{
			return Integer.compare(p1.x, p2.x);
		});
		
		int edgeIdx = 0;
		for(int i = 0; i<N-1; ++i) {
			int u = planets[i].idx;
			int v = planets[i+1].idx;
			int weight = Math.abs(planets[i].x - planets[i+1].x);
			edges[edgeIdx++] = new Edge(u, v, weight);
		}
		
		Arrays.sort(planets, (p1, p2)->{
			return Integer.compare(p1.y, p2.y);
		});
		
		for(int i = 0; i<N-1; ++i) {
			int u = planets[i].idx;
			int v = planets[i+1].idx;
			int weight = Math.abs(planets[i].y - planets[i+1].y);
			edges[edgeIdx++] = new Edge(u, v, weight);
		}
		
	
		Arrays.sort(planets, (p1, p2)->{
			return Integer.compare(p1.z, p2.z);
		});
		
		for(int i = 0; i<N-1; ++i) {
			int u = planets[i].idx;
			int v = planets[i+1].idx;
			int weight = Math.abs(planets[i].z - planets[i+1].z);
			edges[edgeIdx++] = new Edge(u, v, weight);
		}
		
		Arrays.sort(edges, (e1, e2) ->{
			return Integer.compare(e1.w, e2.w);
		});
		
		int ans = 0;
		for(int i = 0; i<3*N-3; ++i) {
			int u = edges[i].u;
			int v = edges[i].v;
			int w = edges[i].w;
			if(union(u, v)) {
				ans+=w;
			}
		}
		
		System.out.println(ans);
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		parent[x] = y;
		return true;
	}
	
}