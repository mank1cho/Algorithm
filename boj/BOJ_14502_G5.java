// https://www.acmicpc.net/problem/14502
// 연구소
// DFS, BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_14502_G5 {
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, ans;
	static int[][] map;
	static List<Pair> virus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>();
        
        for(int i = 0; i<N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<M; ++j) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 2) {
        			virus.add(new Pair(i, j));
        		}
        	}
        }
		
        dfs(0,0,0);
        System.out.println(ans);
    }
	
	static void print() {
		System.out.println("======map=====");
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean isIn(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	
	static void bfs() {
		int[][] muyaho = new int[N][M];
		for(int i = 0; i<N; ++i) {
			muyaho[i] = map[i].clone();
		}
		
		Queue<Pair> q = new LinkedList<>();
		for(Pair position : virus) {
			q.add(position);
		}
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for(int i = 0; i<4; ++i) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isIn(nx, ny) == false || muyaho[nx][ny] != 0) continue;
				q.add(new Pair(nx, ny));
				muyaho[nx][ny] = 2;
			}
		}
		
		int safeZoneCount = 0;
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				if(muyaho[i][j] == 0) safeZoneCount++;
			}
		}
		
		ans = Math.max(ans, safeZoneCount);
	}
	
	static void dfs(int x, int y, int blockCount) {
		if(blockCount == 3) {
			//print();
			bfs();		
			return;
		}
		
		if(y>=M) {
			y = 0;
			x++;
		}
		if(x>=N) return;
		
		if(map[x][y] == 0) {
			map[x][y] = 1;
			dfs(x, y+1, blockCount+1);
			map[x][y] = 0;
		}
		dfs(x, y+1, blockCount);
		
	}
	
}
