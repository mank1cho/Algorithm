// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN
// 1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
// 플로이드 와샬, 다익스트라

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1263 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int x =Integer.parseInt(st.nextToken());
					arr[i][j] = x;
					if(arr[i][j] == 0 && i!=j)
						arr[i][j] = 1<<25;
				}
			}
			
			for(int k=0;k<N;k++) 
				for(int i=0;i<N;i++) 
					for(int j=0;j<N;j++) 
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
			
			int ans = Integer.MAX_VALUE;
			for(int k=0;k<N;k++) {
				int temp=0;
				for(int i=0;i<N;i++) 
					temp+=arr[k][i];
				ans = Math.min(ans,temp);
			}
			

			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	

}


/*
 * 다익스트라
   public class SWEA_1263 {
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			ArrayList<Pair>[] edges = new ArrayList[N+1];
			for(int i = 1; i<=N; ++i) {
				edges[i] = new ArrayList<>();
			}
			
			for(int i = 1; i<=N; ++i) {
				for(int j = 1; j<=N; ++j) {
					int x = Integer.parseInt(st.nextToken());
					if(x==1) edges[i].add(new Pair(j, 1));
				}
			}
			
			int ans = Integer.MAX_VALUE;
			for(int i = 1; i<=N; ++i) {
				ans = Math.min(ans, dijkstra(N, i, edges));
			}

			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static int dijkstra(int N, int start, ArrayList<Pair>[] edges) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(start, 0));
		
		int[] dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		
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
		
		int ret = 0;
		for(int i = 1; i<=N; ++i) {
			ret+=dis[i];
		}
		return ret;
	}

}

*/
