// https://www.acmicpc.net/problem/1197
// 최소 스패닝 트리
// MST

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1197_G4 {
	static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(u, v, w);
		}

		arr = new int[V + 1];
		for (int i = 1; i <= V; ++i) {
			arr[i] = i;
		}

		Arrays.sort(edgeList);

		int ans = 0;
		for (Edge e : edgeList) {
			if (union(e.u, e.v)) {
				ans += e.w;
			}
		}

		System.out.println(ans);
	}

	static int find(int x) {
		if (arr[x] == x)
			return x;
		return arr[x] = find(arr[x]);
	}

	static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a == b)
			return false;
		arr[a] = b;
		return true;
	}
}
