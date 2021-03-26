// https://www.acmicpc.net/problem/17472
// 다리만들기 2
// 구현 시뮬레이션

package boj;

import java.io.*;
import java.util.*;

public class BOJ_17472_G2 {
	
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}
	
	
	static int N, M;
	static int[][] map;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i = 0; i<N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<M; ++j) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) map[i][j] = -1;
        	}
        }
        
        int islandNumber = 1;
        for(int i = 0; i<N; ++i) {
        	for(int j = 0; j<M; ++j) {
        		if(map[i][j] == -1) {
        			dfs(islandNumber++, i, j);
        		}
        	}
        }

        int[][] distanceMatrix = new int[islandNumber][islandNumber];
        for(int i = 0; i<islandNumber; ++i) {
        	Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i<N; ++i) {
        	for(int j = 0; j<M; ++j) {
        		if(map[i][j] == 0) continue;
        		getDistance(distanceMatrix, i, j);
        	}
        }
        
        List<Edge> edges = new ArrayList<>();
        for(int i = 1; i<islandNumber; ++i) {
        	for(int j = 1; j<islandNumber; ++j) {
        		if(distanceMatrix[i][j] == Integer.MAX_VALUE) continue;
        		edges.add(new Edge(i, j, distanceMatrix[i][j]));
        	}
        }
        
        Collections.sort(edges);
        
        parent = new int[islandNumber];
        for(int i = 1; i<islandNumber; ++i) {
        	parent[i] = i;
        }
        
        int ans = 0;
        int cnt = 0;
        for(Edge e : edges) {
        	if(union(e.u, e.v)) {
        		ans+=e.w;
        		cnt++;
        	}
        }

        if(cnt == islandNumber-2) System.out.println(ans);
        else System.out.println(-1);
        
    }
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		parent[x] = y;
		return true;
	}
	
	
	static int dx[] = {1,0};
	static int dy[] = {0,1};
	
	static void getDistance(int[][] distanceMatrix, int x, int y) {
		int startPoint = map[x][y];
		
		for(int i = 0; i<2; ++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			int distance = 0;
			
			if(!isIn(nx,ny)) continue;
			if(map[nx][ny] == startPoint) continue;
			
			while(isIn(nx,ny) && map[nx][ny] == 0) {
				nx+=dx[i];
				ny+=dy[i];
				distance++;
			}
			
			if(!isIn(nx,ny)) continue;
			if(map[nx][ny] == startPoint) continue;
			if(distance < 2) continue;
			
			int endPoint = map[nx][ny];

			distanceMatrix[startPoint][endPoint] = Math.min(distanceMatrix[startPoint][endPoint], distance);
		}
	}
	
	static void dfs(int num, int x, int y) {
		if(isIn(x, y) == false || map[x][y]!=-1) return;
		map[x][y] = num;
		dfs(num, x+1, y);
		dfs(num, x, y+1);
		dfs(num, x-1, y);
		dfs(num, x, y-1);
	}
	
	static boolean isIn(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	
}
