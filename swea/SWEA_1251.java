// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
// 1251. [S/W 문제해결 응용] 4일차 - 하나로
// 크루스칼

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1251 {
	
	static class Edge implements Comparable<Edge>{
		int u, v;
		long w;
		Edge(int u, int v, long w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(w, o.w);
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			for(int i = 1; i<n; ++i) {
				arr[i] = i;
			}
			
			long[][] position = new long[n][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; ++i) {
				position[i][0] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; ++i) {
				position[i][1] = Long.parseLong(st.nextToken());
			}
			
			double e = Double.parseDouble(br.readLine());
			
			Edge[] edges = new Edge[n*(n-1)/2];
			int index = 0;
			for(int i = 0; i<n; ++i) {
				for(int j = i+1; j<n; ++j) {
					edges[index++] = new Edge(i,j, getDistance(position, i, j));
				}
			}

			Arrays.sort(edges);
			
			long ans = 0;
			for(int i = 0; i<edges.length; ++i) {
				if(union(edges[i].u, edges[i].v, arr)) {
					ans+=edges[i].w;
				}
			}
			
			sb.append("#").append(t).append(" ").append(String.format("%.0f", (double)ans*e)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int find(int x, int[] arr) {
		if(x == arr[x]) return x;
		return find(arr[x], arr);
	}
	
	static boolean union(int x, int y, int[] arr) {
		x = find(x, arr);
		y = find(y, arr);
		if(x==y) return false;
		arr[x] = y;
		return true;
	}

	static long getDistance(long[][] position, int i, int j) {
		long x1 = position[i][0];
		long y1 = position[i][1];
		long x2 = position[j][0];
		long y2 = position[j][1];
		return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
	}
}
